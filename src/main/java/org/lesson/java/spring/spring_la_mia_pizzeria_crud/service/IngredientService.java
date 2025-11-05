package org.lesson.java.spring.spring_la_mia_pizzeria_crud.service;

import java.util.List;
import java.util.Optional;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Ingredient;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.IngredientRepository;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    
    @Autowired
    private PizzaRepository pizzaRepo;
    @Autowired
    private IngredientRepository ingredientRepo;
    

    public List<Ingredient> findAll(){
        return ingredientRepo.findAll();
    }

    public Ingredient getById(Integer id){
        return ingredientRepo.findById(id).get();
    }

    public Optional<Ingredient> findById(Integer id){
        return ingredientRepo.findById(id);
    }

    public Ingredient create(Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }

    public Ingredient update(Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }

    public void delete(Ingredient ingredient){
        for(Pizza pizza : ingredient.getPizzas()){
            pizza.getIngredients().remove(ingredient);
            pizzaRepo.save(pizza);
        }
        ingredientRepo.delete(ingredient);
    }

    public void deleteById(Integer id){
        Ingredient ingredient= getById(id);
        delete(ingredient);
    }
}
