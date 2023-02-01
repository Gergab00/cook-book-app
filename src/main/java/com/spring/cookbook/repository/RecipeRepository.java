package com.spring.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cookbook.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}