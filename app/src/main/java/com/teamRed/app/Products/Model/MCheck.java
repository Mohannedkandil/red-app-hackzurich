package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MCheck {

    @JsonProperty("ground_and_sea_cargo")
    private GroundAndSeaCargo ground_and_sea_cargo;

    public GroundAndSeaCargo getground_and_sea_cargo() {
        return ground_and_sea_cargo;
    }

    public void setground_and_sea_cargo(GroundAndSeaCargo ground_and_sea_cargo) {
        this.ground_and_sea_cargo = ground_and_sea_cargo;
    }
}
