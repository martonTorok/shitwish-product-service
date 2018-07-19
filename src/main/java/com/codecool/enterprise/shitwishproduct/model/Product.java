package com.codecool.enterprise.shitwishproduct.model;

import javax.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userId;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private String imageUrl;
    @Column
    private String description;
    @Column
    private int price;

    public Product() {
    }

    public Product(String userId, String name, String category, String imageUrl, String description, int price) {
        this.userId = userId;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
