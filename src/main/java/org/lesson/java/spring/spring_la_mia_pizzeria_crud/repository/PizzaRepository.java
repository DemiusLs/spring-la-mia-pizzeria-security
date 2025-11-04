package org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository;

import java.util.List;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository  <Pizza, Integer>{

    public List<Pizza> findByNameIgnoreCaseContaining(String name);
    
}
