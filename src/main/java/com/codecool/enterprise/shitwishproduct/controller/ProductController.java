package com.codecool.enterprise.shitwishproduct.controller;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/products/{id}", produces = "application/json")
    @ResponseBody
    public Optional<Product> getProduct(@PathVariable("id") long id) {
        return productRepository.findById(id);
    }
}
