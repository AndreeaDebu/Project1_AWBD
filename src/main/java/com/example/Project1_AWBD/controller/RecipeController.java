package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.IngredientService;
import com.example.Project1_AWBD.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("recipes");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes",recipes);
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe",
                recipeService.findById(Long.valueOf(id)));
        return "info";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/recipe/findAll";
    }

    @RequestMapping("/updateRecipeById/{id}")
    public String update(@PathVariable String id, Model model) {
        model.addAttribute("recipe",
                recipeService.findById(Long.valueOf(id)));
        return "recipeform";
    }

    @PostMapping("/addRecipe")
    public String save(Model model) {
        model.addAttribute("recipe", new Recipe());
        List<Ingredient> ingredientList = ingredientService.findAll();
        model.addAttribute("ingredientList", ingredientList );
        return "recipeform";
    }
}
