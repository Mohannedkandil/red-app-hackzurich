package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MCheck {

    @JsonProperty("carbon_footprint")
    private CarbonFootprint carbonFootprint;



    public CarbonFootprint getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(CarbonFootprint carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
    }
}
