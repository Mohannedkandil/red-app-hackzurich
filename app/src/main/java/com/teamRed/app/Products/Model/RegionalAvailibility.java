package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionalAvailibility {

    @JsonProperty("gmti")
    private TicinoProb availibilityInTicino;

    public TicinoProb getAvailibilityInTicino() {
        return availibilityInTicino;
    }

    public void setAvailibilityInTicino(TicinoProb availibilityInTicino) {
        this.availibilityInTicino = availibilityInTicino;
    }
}
