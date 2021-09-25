package com.teamRed.app.Products.Model;

import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        var product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
