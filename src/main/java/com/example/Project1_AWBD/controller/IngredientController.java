package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("/findAll")
    public List<Ingredient> findAll() {
        return ingredientService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Ingredient findById(@PathVariable Long id) {
        return ingredientService.findById(id);
    }

    @DeleteMapping
    void deleteById(Long id) {
        ingredientService.deleteById(id);
    }

//    @PutMapping("/update-ingredient/{id}")
//    public Ingredient update(@RequestBody Ingredient newIngredient, @PathVariable Long id) {
//        return ingredientService.update(newIngredient, id);
//    }

    @PostMapping("/addIngredients")
    public Ingredient save(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

}
