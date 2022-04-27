package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
import com.example.Project1_AWBD.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("recipe " + id + " does not exist");
        }
        return recipe.get();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long id) {
        /*Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("recipe " + id + " does not exist");
        }
        Recipe recipe1 = recipe.get();
        List<Ingredient> ingredients = new LinkedList<Ingredient>();
        recipe1.getCategories().iterator().forEachRemaining(ingredients::add);
        for (Ingredient ingredient : ingredients
        ) {
            recipe1.
        }
        recipeRepository.deleteById(id);*/
    }

    @Override
    public Recipe update(Recipe newRecipe, Long id) {
        Recipe recipe = findById(id);
        recipe.setDescription(newRecipe.getDescription());
        recipe.setCookTime(newRecipe.getCookTime());
        recipe.setDifficulty(newRecipe.getDifficulty());
        recipe.setPrepTime(newRecipe.getPrepTime());
        recipe.setServings(newRecipe.getServings());
        save(recipe);
        return recipe;
    }
}
