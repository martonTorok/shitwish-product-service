package com.codecool.enterprise.shitwishproduct.controller;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import com.codecool.enterprise.shitwishproduct.service.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products/{id}", produces = "application/json")
    @ResponseBody
    public Optional<Product> getProduct(@PathVariable("id") long id) {
        return productRepository.findById(id);
    }


    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestHeader String header,
            @RequestBody Product product) {

        String expectedId = productRepository.getOne(id).getUserId();
        String actualId = "";
        if (!actualId.equals(expectedId)) {
            return new ResponseEntity<Product>( HttpStatus.UNAUTHORIZED );
        }
        productRepository.save(product);
        return new ResponseEntity<>( product, HttpStatus.OK );
    }


}
