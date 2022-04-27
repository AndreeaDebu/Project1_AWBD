package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
import com.example.Project1_AWBD.repositories.IngredientRepository;
import com.example.Project1_AWBD.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipeList = (List<Recipe>) recipeRepository.findAll();
        if (recipeList.isEmpty()) {
            throw new ResourceNotFoundException("No recipies founded");
        }
        return recipeList;
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
    @Transactional
    public Recipe save(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        if (recipe.getIngredients() != null) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.setRecipe(savedRecipe);
                ingredientRepository.save(ingredient);
            }
        }
        return savedRecipe;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty()) {
            throw new ResourceNotFoundException("recipe " + id + " does not exist");
        }
        recipeRepository.deleteById(id);
    }

    @Override
    public Recipe update(Recipe newRecipe, Long id) {
        Recipe recipe = findById(id);
        if (recipe == null) {
            throw new ResourceNotFoundException("recipe " + id + " does not exist");
        }
        recipe.setDescription(newRecipe.getDescription());
        recipe.setCookTime(newRecipe.getCookTime());
        recipe.setDifficulty(newRecipe.getDifficulty());
        recipe.setPrepTime(newRecipe.getPrepTime());
        recipe.setServings(newRecipe.getServings());
        return save(recipe);
    }

    @Override
    public void deleteAll() {
        recipeRepository.deleteAll();
    }
}
