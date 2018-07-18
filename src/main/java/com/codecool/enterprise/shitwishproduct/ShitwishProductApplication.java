package com.codecool.enterprise.shitwishproduct;

import com.codecool.enterprise.shitwishproduct.model.Product;
import com.codecool.enterprise.shitwishproduct.repository.ProductRepository;
import org.jose4j.jwk.HttpsJwks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShitwishProductApplication {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShitwishProductApplication.class, args);
    }

    @Bean
    public HttpsJwks getKeyStore(){
        return new HttpsJwks(System.getenv("JWKSURI"));
    }

    @Bean
    public CommandLineRunner init() {
        return (String... args) -> {
            Product pr1 = new Product();
            Product pr2 = new Product();
            Product pr3 = new Product();
            productRepository.save(pr1);
            productRepository.save(pr2);
            productRepository.save(pr3);
        };
    }
}
