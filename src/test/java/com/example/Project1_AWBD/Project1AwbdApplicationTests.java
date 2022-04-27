package com.example.Project1_AWBD;

import com.example.Project1_AWBD.entities.Difficulty;
import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Project1AwbdApplicationTests {

	@Autowired
	RecipeService recipeService;

	@Test
	void contextLoads() {
	}

	@Test
	public void test_add_recipe(){
		List<Ingredient> ingredients = new ArrayList<>();
		Ingredient ingredient = new Ingredient();
		ingredient.setAmount(1L);
		ingredients.add(ingredient);

		Recipe recipe =  new Recipe();
		recipe.setServings(2);
		recipe.setDifficulty(Difficulty.EASY);
		recipe.setCookTime("12m");
		recipe.setPrepTime("30m");
		recipe.setIngredients(ingredients);
		recipeService.save(recipe);
	}

	@Test
	public void test_update_recipe(){
		Recipe recipe =  new Recipe();
		recipe.setServings(5);
		recipe.setDifficulty(Difficulty.HARD);
		recipe.setCookTime("12m");
		recipe.setPrepTime("50m");
		recipeService.update(recipe,1L);
	}

	@Test
	public void test_delete_recipe(){
		recipeService.deleteById(4L);
	}
}
