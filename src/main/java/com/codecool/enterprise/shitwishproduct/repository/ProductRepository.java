package com.codecool.enterprise.shitwishproduct.repository;

import com.codecool.enterprise.shitwishproduct.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Long> {
    @CrossOrigin
    Product getById(@Param("id") Long id);

    @CrossOrigin
    @Query(value = "SELECT p FROM Product p WHERE name LIKE %:query% ORDER BY id")
    List<Product> findAllByName(@Param("query") String query, Pageable pageable);
}
