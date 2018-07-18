package com.codecool.enterprise.shitwishproduct;

import org.jose4j.jwk.HttpsJwks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShitwishProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShitwishProductApplication.class, args);
    }

    @Bean
    public HttpsJwks getKeyStore(){
        return new HttpsJwks(System.getenv("JWKSURI"));
    }
}
