package com.teamRed.app.Products.Model;

import org.springframework.data.annotation.PersistenceConstructor;

public class Product {

    private final String Id;
    private final String name;

    @PersistenceConstructor
    public Product(String Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }
}
