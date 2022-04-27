package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Ingredient;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
import com.example.Project1_AWBD.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    @Transactional
    public Ingredient findById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isEmpty()) {
            log.error("ingredient " + id + " does not exist");
            throw new ResourceNotFoundException("ingredient " + id + " does not exist");
        }
        return ingredient.get();
    }

    @Override
    @Transactional
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
        log.info("Ingredient with id " + id + "has been deleted");
    }
}
