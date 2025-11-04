package org.lesson.java.spring.spring_la_mia_pizzeria_crud.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "pizzas")
public class Pizza {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    

    @OneToMany(mappedBy = "pizza" , cascade = {CascadeType.REMOVE})
    private List <Offer> offers;

    @ManyToMany()
    @JoinTable(
        name="ingredient_pizza",
        joinColumns = @JoinColumn(name="pizza_id"),
        inverseJoinColumns = @JoinColumn(name="ingredient_id")
    )
    private List<Ingredient> ingredients;
   

    @NotBlank(message = "The name can't be null, empty or blank")
    @Size(min=1 ,max=50 , message = "The name size must be longer than 1 and shorter than 50")
    private String name;
    @NotBlank(message = "The description can't be null, empty or blank")
     @Size(min=10 ,max=150 , message = "The description size must be longer than 10 and shorter than 150")
    private String description;
    @NotBlank(message = "The url can't be null, empty or blank")
     @Size(min=1 ,max=50 , message = "The url size must be longer than 1 and shorter than 50")
    private String url;
    @DecimalMin( value ="0.0", inclusive= false , message = "Price must be positive"  )
    private BigDecimal price;


    //getter aand setter
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public List<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    

    @Override
    public String toString(){

        return String.format("%s Descrizione: %s, Prezzo: %s",  name , description , price);
    }

}
