package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class RecipeServiceImplTest {

    @Autowired
    RecipeService recipeService;


    @Test
    @Order(1)
    public void test_if_save() {
        Recipe recipe = new Recipe();
        assertNotNull(recipeService.save(recipe));
    }

    @Test
    @Order(2)
    public void test_if_findById() {
        Recipe recipe = new Recipe();
        recipeService.save(recipe);
        assertNotNull(recipeService.findById(recipe.getId()));
    }

    @Test
    @Order(3)
    public void test_if_findAll() {
        Recipe recipe = new Recipe();
        recipeService.save(recipe);
        assertNotNull(recipeService.findAll());
    }

    @Test
    @Order(4)
    public void test_if_delete() {
        Recipe recipe = new Recipe();
        recipeService.save(recipe);

        recipeService.deleteById(recipe.getId());
        assertThrows(ResourceNotFoundException.class, () -> {
            recipeService.findById(recipe.getId());
        });
    }

    @Test
    @Order(5)
    public void test_if_deleteAll(){
        recipeService.deleteAll();
        ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            recipeService.findAll();
        });
        Assertions.assertEquals("No recipies founded", thrown.getMessage());
    }
}
