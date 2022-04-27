package com.example.Project1_AWBD;

import com.example.Project1_AWBD.entities.Difficulty;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project1AwbdApplicationTests {

	@Autowired
	RecipeService recipeService;

	@Test
	void contextLoads() {
	}

	@Test
	public void test_add_recipe(){
		Recipe recipe =  new Recipe();
		recipe.setServings(2);
		recipe.setDifficulty(Difficulty.EASY);
		recipe.setCookTime("12m");
		recipe.setPrepTime("30m");
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
}
