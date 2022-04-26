package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Category;
import com.example.Project1_AWBD.entities.Recipe;
import com.example.Project1_AWBD.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Recipe save(Category category) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
