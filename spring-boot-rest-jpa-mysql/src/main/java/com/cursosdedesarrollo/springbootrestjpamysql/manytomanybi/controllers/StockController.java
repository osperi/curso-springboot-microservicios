package com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.controllers;

import com.cursosdedesarrollo.springbootrestjpamysql.ResourceNotFoundException;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.domain.Stock;
import com.cursosdedesarrollo.springbootrestjpamysql.manytomanybi.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    // Get All Stocks
    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        List<Stock> result = new ArrayList<Stock>();
        Iterable<Stock> allStocks = stockRepository.findAll();
        for (Stock cat: allStocks) {
            result.add(cat);
        }
        return result;
    }

    // Create a new Stock
    @PostMapping("/stocks")
    public Stock createStock(@Valid @RequestBody Stock stock) {
        return stockRepository.save(stock);
    }

    // Get a Single Stock
    @GetMapping("/stocks/{id}")
    public Stock getStockById(@PathVariable(value = "id") Integer stockId) {
        return stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
    }

    // Update a Stock
    @PutMapping("/stocks/{id}")
    public Stock updateStock(@PathVariable(value = "id") Integer stockId,
                           @Valid @RequestBody Stock stockDetails) {

        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));

        stock.setStockCode(stockDetails.getStockCode());
        stock.setStockId(stockDetails.getStockId());
        stock.setCategories(stockDetails.getCategories());

        Stock updatedStock = stockRepository.save(stock);
        return updatedStock;
    }

    // Delete a Stock
    @DeleteMapping("/stocks/{id}")
    public Stock deleteStock(@PathVariable(value = "id") Integer stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stockId));
        stockRepository.delete(stock);
        return stock;
    }
}
