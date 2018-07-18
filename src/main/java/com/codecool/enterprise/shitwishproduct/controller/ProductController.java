package com.codecool.enterprise.shitwishproduct.controller;

import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

}
