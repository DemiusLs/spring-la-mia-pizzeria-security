package org.lesson.java.spring.spring_la_mia_pizzeria_crud.service;

import java.util.List;
import java.util.Optional;


import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Offer;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.IngredientRepository;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.OfferRepository;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {


    @Autowired
    private PizzaRepository pizzaRepo;
    @Autowired
    private IngredientRepository  ingredientRepo;
    @Autowired
    private OfferRepository offerRepo;


    public List<Pizza> findAll(){
        return pizzaRepo.findAll();
    }

    public Pizza getById(Integer id){
        return pizzaRepo.findById(id).get();
    }

    public Optional<Pizza>findById(Integer id){
        return pizzaRepo.findById(id);
    }

    public List<Pizza> findByName(String name){
        return pizzaRepo.findByNameIgnoreCaseContaining(name);
    }

    public Pizza create(Pizza pizza){
        return pizzaRepo.save(pizza);
    }

    public Pizza update(Pizza pizza){
        return pizzaRepo.save(pizza);
    }
    
    public void delete(Pizza pizza){
        // for(Ingredient ingredientToDelete : pizza.getIngredients()){
        //     ingredientRepo.delete(ingredientToDelete);
        //  }
        for(Offer offerToDelete : pizza.getOffers()){
            offerRepo.delete(offerToDelete);
        }
        pizzaRepo.delete(pizza);
    }


    public void deleteById(Integer id){
        Pizza pizza = getById(id);
        delete(pizza);
    }

}
