package com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.controllers;

import com.cursosdedesarrollo.springbootrestjpamysql.ResourceNotFoundException;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Category;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Stock;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.repositories.CategoryRepository;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class StockCategoryController {

    @Autowired
    CategoryController categoryController;
    @Autowired
    StockController stockController;

    @GetMapping("/categories/{id}/stocks")
    public Set<Stock> getCategoryStocks(@PathVariable(value = "id") Integer categoryId) {
        Category category = categoryController.getCategoryById(categoryId);
        return category.getStocks();
    }

    @PostMapping("/categories/{idCat}/stocks/{idSto}")
    public Category addCategoryStocks(@PathVariable(value = "idCat") Integer categoryId,
                                         @PathVariable(value = "idSto") Integer stockId) {
        Category category = categoryController.getCategoryById(categoryId);
        Stock stock = stockController.getStockById(stockId);
        category.getStocks().add(stock);
        Category categoryUpdated = categoryController.updateCategory(category.getCategoryId(),category);
        return categoryUpdated;
    }

    @GetMapping("/stocks/{id}/categories")
    public Set<Category> getStockCategories(@PathVariable(value = "id") Integer stockId) {
        Stock stock = stockController.getStockById(stockId);
        return stock.getCategories();
    }
}
