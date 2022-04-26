package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Category;
import com.example.Project1_AWBD.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Recipe> findAll();
    Optional<Category> findById(Long id);
    Recipe save(Category category);
    void deleteById(Long id);
}
