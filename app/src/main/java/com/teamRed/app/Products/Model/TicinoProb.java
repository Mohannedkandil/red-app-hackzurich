package com.teamRed.app.Products.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TicinoProb {

    @JsonProperty("gmti")
    private int probabilityInTicino;

    public int getProbabilityInTicino() {
        return probabilityInTicino;
    }

    public void setProbabilityInTicino(int probabilityInTicino) {
        this.probabilityInTicino = probabilityInTicino;
    }
}
