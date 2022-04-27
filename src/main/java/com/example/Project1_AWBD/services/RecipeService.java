package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Recipe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();

    Recipe findById(Long id);

    Recipe save(Recipe recipe);

    void deleteById(Long id);

    Recipe update(Recipe newRecipe, Long id);

    void deleteAll();
}
