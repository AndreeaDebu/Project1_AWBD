package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
import com.example.Project1_AWBD.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            throw new ResourceNotFoundException("ingredient " + id + " does not exist");
        }
        return ingredient.get();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
