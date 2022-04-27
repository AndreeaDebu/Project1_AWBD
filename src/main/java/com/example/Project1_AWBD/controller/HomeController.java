package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){
        return "recipes";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("errorMessage","Invalid user or password");
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }


    @RequestMapping({"", "/", "/index"})
    public ModelAndView recipesList(){
        ModelAndView modelAndView = new ModelAndView("recipes");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes",recipes);
        return modelAndView;
    }
}
