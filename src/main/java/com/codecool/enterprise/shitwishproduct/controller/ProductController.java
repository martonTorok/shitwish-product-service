package com.codecool.enterprise.shitwishproduct.controller;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import com.codecool.enterprise.shitwishproduct.service.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Authentication authentication;

    @GetMapping(value = "/product/{id}", produces = "application/json")
    public ResponseEntity<Product> getProduct(@PathVariable("id")Long id) {
        return new ResponseEntity<>(productRepository.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/products", produces = "application/json")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}", produces = "application/json")
    public ResponseEntity<Product> deleteProduct(@RequestHeader String auth, @PathVariable("id")Long id) {

        String userId = authentication.authorize(auth);

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        Product productToDelete = productRepository.getById(id);
        productRepository.delete(productToDelete);
        return new ResponseEntity<>(productToDelete, HttpStatus.OK);
    }


    @PostMapping(value = "/product", consumes = "application/json")
    public ResponseEntity<Product> addProduct(@RequestHeader String auth, @RequestBody Product product){

        String userId= authentication.authorize(auth);

        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        product.setUserId(userId);
        return new ResponseEntity<>(productRepository.saveAndFlush(product), HttpStatus.OK);

    }


    @PutMapping(value = "/product/{id}", consumes = "application/json")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestHeader String auth,
            @RequestBody Product product) {

        String expectedId = productRepository.getOne(id).getUserId();
        String actualId = authentication.authorize(auth);
        if (!actualId.equals(expectedId)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        productRepository.save(product);
        return new ResponseEntity<>( product, HttpStatus.OK );
    }


}
