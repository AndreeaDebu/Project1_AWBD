package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findById(Long id);
    Ingredient save(Ingredient ingredient);
    void deleteById(Long id);
}
