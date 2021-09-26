package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @JsonProperty("id")
    private String Id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("regional_availability")
    private RegionalAvailibility regionalAvailibility;
    @JsonProperty("m_check2")
    private MCheck mCheck;
    @JsonProperty("declarations")
    private Declaration declaration;

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

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionalAvailibility getRegionalAvailibility() {
        return regionalAvailibility;
    }

    public void setRegionalAvailibility(RegionalAvailibility regionalAvailibility) {
        this.regionalAvailibility = regionalAvailibility;
    }


    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public MCheck getmCheck() {
        return mCheck;
    }

    public void setmCheck(MCheck mCheck) {
        this.mCheck = mCheck;
    }
}
