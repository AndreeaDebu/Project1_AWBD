package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/findAll")
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Recipe findById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @DeleteMapping
    void deleteById(Long id) {
        recipeService.deleteById(id);
    }

    @PutMapping("/updateRecipeById/{id}")
    public Recipe update(@RequestBody Recipe newRecipe, @PathVariable Long id) {
        return recipeService.update(newRecipe, id);
    }

    @PostMapping("/addRecipe")
    public Recipe save(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }
}
