package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
