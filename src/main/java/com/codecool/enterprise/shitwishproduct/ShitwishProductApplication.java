package com.codecool.enterprise.shitwishproduct;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class ShitwishProductApplication {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShitwishProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return (String... args) -> {
            Product prod1 = new Product();
            Product prod2 = new Product();
            Product prod3 = new Product();
            productRepository.save(prod1);
            productRepository.save(prod2);
            productRepository.save(prod3);

        };
    }
}
