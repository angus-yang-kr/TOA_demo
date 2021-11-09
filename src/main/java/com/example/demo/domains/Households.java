package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Households {
    private final String ehhn;
    private final Float[] features;

    public Households(@JsonProperty("ehhn") String ehhn,
                      @JsonProperty("features") Float[] features) {
        this.ehhn = ehhn;
        this.features = features;
    }

    public String getEhhn() {
        return ehhn;
    }

    public Float[] getFeatures() {
        return features;
    }
}
