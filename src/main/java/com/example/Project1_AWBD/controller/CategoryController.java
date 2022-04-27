package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Category;
import com.example.Project1_AWBD.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/findAll")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @PostMapping("/add")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }
}
