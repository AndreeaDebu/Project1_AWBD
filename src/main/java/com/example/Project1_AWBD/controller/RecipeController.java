package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/find-all-recipes")
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/find-recipe/{id}")
    public Recipe findById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @DeleteMapping
    void deleteById(Long id) {
        recipeService.deleteById(id);
    }

    @PutMapping("/update-recipe/{id}")
    public Recipe update(@RequestBody Recipe newRecipe, @PathVariable Long id) {
        return recipeService.update(newRecipe, id);
    }

    @PostMapping("/add-recipe")
    public Recipe save(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }
}
