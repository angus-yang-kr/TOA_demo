package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scoring {
    private final String[] feature_keys;
    private final Integer[] slot_ids;
    private final Integer[] premium_placements;
    private final Float score_weight;
    private final Float price_weight;

    public Scoring(@JsonProperty("feature_keys") String[] feature_keys,
                   @JsonProperty("slot_ids") Integer[] slot_ids,
                   @JsonProperty("premium_placements") Integer[] premium_placements,
                   @JsonProperty("score_weight") Float score_weight,
                   @JsonProperty("price_weight") Float price_weight) {
        this.feature_keys = feature_keys;
        this.slot_ids = slot_ids;
        this.premium_placements = premium_placements;
        this.score_weight = score_weight;
        this.price_weight = price_weight;
    }

    public String[] getFeature_keys() {
        return feature_keys;
    }

    public Integer[] getSlot_ids() {
        return slot_ids;
    }

    public Integer[] getPremium_placements() {
        return premium_placements;
    }

    public Float getScore_weight() {
        return score_weight;
    }

    public Float getPrice_weight() {
        return price_weight;
    }
}
