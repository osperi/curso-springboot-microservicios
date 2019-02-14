package com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.controllers;

import com.cursosdedesarrollo.springbootrestjpamysql.ResourceNotFoundException;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Category;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    // Get All Categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        List<Category> result = new ArrayList<Category>();
        Iterable<Category> allCategories = categoryRepository.findAll();
        for (Category cat: allCategories) {
            result.add(cat);
        }
        return result;
    }

    // Create a new Category
    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    // Get a Single Category
    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable(value = "id") Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
    }

    // Update a Category
    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable(value = "id") Integer categoryId,
                           @Valid @RequestBody Category categoryDetails) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setName(categoryDetails.getName());
        category.setDesc(categoryDetails.getDesc());
        category.setStocks(categoryDetails.getStocks());

        Category updatedCategory = categoryRepository.save(category);
        return updatedCategory;
    }

    // Delete a Category
    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable(value = "id") Integer categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepository.delete(category);
        return category;
    }
}
