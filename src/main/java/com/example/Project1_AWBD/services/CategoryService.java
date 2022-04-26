package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Category;
import com.example.Project1_AWBD.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
