package com.spring.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.spring.cookbook.model.Recipe;
import com.spring.cookbook.repository.RecipeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
  
  @Autowired
  private RecipeRepository recipeRepository;
  
  @GetMapping
  public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }
  
  @GetMapping("/{id}")
  /*
   * @PathVariable is used to bind the id path variable to the id method parameter.
   * Essentially, it tells Spring to get the value of the id path variable and pass
   * it to the method.
   * 
   * @GetMapping("/{id}") is used to map HTTP GET requests to the getRecipeById
   * 
   * Example request: GET /api/recipes/1
   * 
   */
  public Recipe getRecipeById(@PathVariable Long id) {
    return recipeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id " + id));
  }
  
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  /*
   * @ResponseStatus(HttpStatus.CREATED) is used to set the HTTP status code to 201
   * Created. This is the status code that should be returned when a new resource
   * is created.
   * 
   * @RequestBody is used to bind the request body to the Recipe object.
   * Essentially, it tells Spring to convert the request body into a Recipe object
   * and pass it to the method.
   * Example request body:
   * {
   *  "name": "Chicken Tikka Masala",
   * "ingredients": "Chicken, tomatoes, onions, garlic, ginger, garam masala, turmeric, cumin, coriander, salt, yogurt, oil",
   * "directions": "1. Marinate chicken in yogurt, salt, turmeric, cumin, coriander, and garam masala for 1 hour. 2. Heat oil in a large skillet over medium-high heat. 3. Add onions and cook until translucent. 4. Add garlic and ginger and cook for 1 minute. 5. Add tomatoes and cook until soft. 6. Add chicken and cook until cooked through. 7. Add salt to taste."
   * }
   * 
  */
  public Recipe createRecipe(@RequestBody Recipe recipe) {
    return recipeRepository.save(recipe);
  }
  
  @PutMapping("/{id}")
  /*
   * @PutMapping("/{id}") is used to map HTTP PUT requests to the updateRecipe
   * method.
   * 
   * Example request: PUT /api/recipes/1
   * 
   * Example request body:
   * {
   * "name": "Chicken Tikka Masala",
   * "ingredients": "Chicken, tomatoes, onions, garlic, ginger, garam masala, turmeric, cumin, coriander, salt, yogurt, oil",
   * "directions": "1. Marinate chicken in yogurt, salt, turmeric, cumin, coriander, and garam masala for 1 hour. 2. Heat oil in a large skillet over medium-high heat. 3. Add onions and cook until translucent. 4. Add garlic and ginger and cook for 1 minute. 5. Add tomatoes and cook until soft. 6. Add chicken and cook until cooked through. 7. Add salt to taste."
   * }
   * 
   */
  public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
    Recipe existingRecipe = recipeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id " + id));
    existingRecipe.setName(recipe.getName());
    existingRecipe.setIngredients(recipe.getIngredients());
    existingRecipe.setDirections(recipe.getDirections());
    return recipeRepository.save(existingRecipe);
  }
  
  @DeleteMapping("/{id}")
  public void deleteRecipe(@PathVariable Long id) {
    Recipe existingRecipe = recipeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id " + id));
    recipeRepository.delete(existingRecipe);
  }
  
  class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
      super(message);
    }
  }
}
