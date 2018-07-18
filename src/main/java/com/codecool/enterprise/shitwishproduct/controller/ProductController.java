package com.codecool.enterprise.shitwishproduct.controller;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "application/json")
    public Product addProduct(@RequestBody Product product){


        return productRepository.saveAndFlush(product);
    }
}
