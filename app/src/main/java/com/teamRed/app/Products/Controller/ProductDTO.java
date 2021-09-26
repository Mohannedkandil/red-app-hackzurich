package com.teamRed.app.Products.Controller;

import com.teamRed.app.Products.Model.MCheck;
import com.teamRed.app.Products.Model.Product;
import com.teamRed.app.Products.Model.ProductImage;

public class ProductDTO {
    private String name;
    private String Id;
    private ProductImage image;
    private MCheck mcheckInfo;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.Id = product.getId();
        this.image = product.getImage();
        if (product.getmCheck() != null) {
            this.mcheckInfo = product.getmCheck();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
