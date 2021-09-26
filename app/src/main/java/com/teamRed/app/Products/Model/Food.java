package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Food {

    @JsonProperty("food_declaration_gtins")
    private String[] foodDeclarationGtins;

    public String[] getFoodDeclarationGtins() {
        return foodDeclarationGtins;
    }

    public void setFoodDeclarationGtins(String[] foodDeclarationGtins) {
        this.foodDeclarationGtins = foodDeclarationGtins;
    }
}
