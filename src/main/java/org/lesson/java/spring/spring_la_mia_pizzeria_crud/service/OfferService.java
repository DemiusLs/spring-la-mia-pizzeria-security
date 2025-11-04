package org.lesson.java.spring.spring_la_mia_pizzeria_crud.service;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Offer;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {
    
    @Autowired
    private OfferRepository offerRepo ;

    public Offer getById(Integer id){
        return offerRepo.findById(id).get();
    }

    public Offer create(Offer offer){
        return offerRepo.save(offer);
    }

    public Offer update(Offer offer){
        return offerRepo.save(offer);
    }
}
