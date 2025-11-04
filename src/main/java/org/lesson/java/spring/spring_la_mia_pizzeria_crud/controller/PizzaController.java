package org.lesson.java.spring.spring_la_mia_pizzeria_crud.controller;

import java.util.List;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Offer;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.IngredientRepository;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;
    @Autowired
    IngredientRepository ingredientRepo;
    
    @GetMapping("/index")
    public String index(Model model) {
        List<Pizza> pizzas = pizzaService.findAll();
        model.addAttribute("pizzas" , pizzas );
        return "/pizzas/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id , Model model ){

        Pizza pizza = pizzaService.findById(id).get();
        model.addAttribute("pizza", pizza);
        return "/pizzas/show";
    }


    @GetMapping("/searchByName")
    public String searchByName(@RequestParam(name ="name", required = false) String name , Model model ){

        List<Pizza> pizzas ;
        if(name != null && !name.isEmpty()){
            pizzas = pizzaService.findByName(name); 
        }else{
            pizzas = pizzaService.findAll();
        }
        model.addAttribute("pizzas", pizzas);
        return "/pizzas/index";
    }


    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("ingredients", ingredientRepo.findAll());
        return "/pizzas/create-or-edit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("pizza") Pizza formPizza,BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("ingredients", ingredientRepo.findAll());
            return "pizzas/create-or-edit";
        }  
            pizzaService.create(formPizza);

        return "redirect:/pizzas/index";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,  Model model ){
        model.addAttribute("pizza", pizzaService.getById(id));
        model.addAttribute("ingredients", ingredientRepo.findAll());
        model.addAttribute("edit", true);
        return "/pizzas/create-or-edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizza") Pizza formPizza,BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("ingredients", ingredientRepo.findAll());
            return "pizzas/create-or-edit";
        }  
            pizzaService.update(formPizza);

        return "redirect:/pizzas/index";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        
        pizzaService.deleteById(id);
        
        return "redirect:/pizzas/index";
    }


    @GetMapping("/offers/{id}")
    public String createNewOffer(@PathVariable Integer id, Model model){

        Offer offer = new Offer();
        offer.setPizza(pizzaService.getById(id));
        model.addAttribute("offer" , offer);

        return "/offers/create-or-edit";
    }

    



}
