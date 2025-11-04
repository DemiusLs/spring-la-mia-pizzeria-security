package org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Offer;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository  <Offer, Integer>{
    
}
