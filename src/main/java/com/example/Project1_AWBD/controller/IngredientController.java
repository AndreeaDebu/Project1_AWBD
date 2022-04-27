package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("ingredients");
        List<Ingredient> ingredients = ingredientService.findAll();
        modelAndView.addObject("ingredients",ingredients);
        return modelAndView;
    }

    @GetMapping("/findById/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("ingredients",
                ingredientService.findById(Long.valueOf(id)));
        return "info";
    }

    @DeleteMapping
    public String deleteById(@PathVariable String id) {
        ingredientService.deleteById(Long.valueOf(id));
        return "redirect:/ingredient/list";
    }


}
