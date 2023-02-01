package com.spring.cookbook.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * This is the Recipe model class. It is annotated with @Entity to indicate that it is a JPA entity.
 * It is also annotated with @Table to indicate that it is mapped to the recipes table in the database.
 * The @Id annotation indicates that the id field is the primary key of the table.
 * The @GeneratedValue annotation indicates that the id field is auto-generated.
 * The @Column annotation indicates that the name, ingredients, and directions fields are mapped to the name, ingredients, and directions columns in the recipes table.
 * The Recipe class has a no-argument constructor and a constructor that takes three arguments.
 * The Recipe class also has getters and setters for each field.
 * The Recipe class is a JavaBean because it has a no-argument constructor and getters and setters for each field.
 * 
 */
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "directions")
    private String directions;

    public Recipe() {}

    public Recipe(String name, String ingredients, String directions) {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
}
