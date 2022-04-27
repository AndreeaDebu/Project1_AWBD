package com.example.Project1_AWBD.services;

import com.example.Project1_AWBD.entities.Category;
import com.example.Project1_AWBD.exceptions.ResourceNotFoundException;
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
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException("category " + id + " does not exist");
        }
        return category.get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
