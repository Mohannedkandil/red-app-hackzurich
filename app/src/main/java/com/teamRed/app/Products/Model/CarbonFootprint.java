package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarbonFootprint {

    @JsonProperty("image")
    private ImageMCheck imageMCheck;

    @JsonProperty("ground_and_sea_cargo")
    private GroundAndSeaCargo groundAndSeaCargo;

    public ImageMCheck getImageMCheck() {
        return imageMCheck;
    }

    public void setImageMCheck(ImageMCheck imageMCheck) {
        this.imageMCheck = imageMCheck;
    }

    public GroundAndSeaCargo getGroundAndSeaCargo() {
        return groundAndSeaCargo;
    }

    public void setGroundAndSeaCargo(GroundAndSeaCargo groundAndSeaCargo) {
        this.groundAndSeaCargo = groundAndSeaCargo;
    }
}
