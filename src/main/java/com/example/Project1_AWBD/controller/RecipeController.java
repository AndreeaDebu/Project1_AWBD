package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/find-all-recipes")
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @PostMapping("/add-recipe")
    public Recipe save(Recipe recipe) {
        return recipeService.save(recipe);
    }
}
