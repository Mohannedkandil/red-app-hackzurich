package com.teamRed.app.User.Model;

import com.teamRed.app.Products.Model.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Document(collection = "users")
public class User {

    @Id
    private final String email;
    private int level;
    private int experiencePoints;
    private List<Product> groceryList;
    private List<Product> productCart;



    public User(String email) {
        this.email = email;
        this.level = 1;
        this.experiencePoints = 0;
    }

    public User(String email, int level, int experiencePoints, List<Product> groceryList, List<Product> productCart) {
        this.email = email;
        this.groceryList = groceryList;
        this.productCart = productCart;
        if (level <= 0)
            this.level = 1;
        this.level = level;
        if (experiencePoints <= 0)
            this.experiencePoints = 0;
        this.experiencePoints = experiencePoints;
    }

    @PersistenceConstructor
    public User(int level, String email, int experiencePoints, List<Product> groceryList, List<Product> productCart) {
        this.email = email;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.groceryList = groceryList;
        this.productCart = productCart;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Product> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Product> groceryList) {
        this.groceryList = groceryList;
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public void setProductCart(List<Product> productCart) {
        this.productCart = productCart;
    }

    public boolean checkGroceryListProductExistance(String productId) {
        var flag = new AtomicBoolean(false);
        this.getGroceryList().forEach(product -> {
            if (product.getId().equals(productId)) {
                flag.set(true);
            }
        });
        return flag.get();
    }

    public void addToGroceryList(Product product) {
        this.getGroceryList().add(product);
    }
}
