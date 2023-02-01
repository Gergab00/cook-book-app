package com.spring.cookbook.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("Hello World");
        return "Hello World";
    }

    // Get all recipes
    @GetMapping
    public String getAllRecipes() {
        return "Showing all recipes";
    }

    // Get a recipe by id
    @GetMapping("/{id}")
    public String getRecipeById(@PathVariable int id) {
        return "Showing recipe with id: " + id;
    }

    // Add a recipe
    @PostMapping
    public String addRecipe() {
        return "Adding a new recipe";
    }

    // Delete a recipe
    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable int id) {
        return "Deleting the recipe with id: " + id;
    }
}
