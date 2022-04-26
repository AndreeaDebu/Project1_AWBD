package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> findAll();
    Optional<Recipe> findById(Long id);
    Recipe save(Recipe recipe);
    void deleteById(Long id);
}
