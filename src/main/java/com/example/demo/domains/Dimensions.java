package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class Dimensions {
    private final String alt_text;
    private final String campaign_id;
    private final String[] destination_upcs;
    private final Float product_convenience_dim_perc_avg;
    private final Float product_health_dim_perc_avg;
    private final Float product_inspiration_dim_perc_avg;
    private final Float product_keto_avg;
    private final Float product_paleo_avg;
    private final Float product_price_dim_perc_avg;
    private final Float product_quality_dim_perc_avg;
    private final Float product_vegan_avg;
    private final String updated;

    public Dimensions(@JsonProperty("alt_text") String alt_text,
                      @JsonProperty("campaign_id") String campaign_id,
                      @JsonProperty("destination_upcs") String[] destination_upcs,
                      @JsonProperty("product_convenience_dim_perc_avg") Float product_convenience_dim_perc_avg,
                      @JsonProperty("product_health_dim_perc_avg") Float product_health_dim_perc_avg,
                      @JsonProperty("product_inspiration_dim_perc_avg") Float product_inspiration_dim_perc_avg,
                      @JsonProperty("product_keto_avg") Float product_keto_avg,
                      @JsonProperty("product_paleo_avg") Float product_paleo_avg,
                      @JsonProperty("product_price_dim_perc_avg") Float product_price_dim_perc_avg,
                      @JsonProperty("product_quality_dim_perc_avg") Float product_quality_dim_perc_avg,
                      @JsonProperty("product_vegan_avg") Float product_vegan_avg,
                      @JsonProperty("updated") String updated) {
        this.alt_text = alt_text;
        this.campaign_id = campaign_id;
        this.destination_upcs = destination_upcs;
        this.product_convenience_dim_perc_avg = product_convenience_dim_perc_avg;
        this.product_health_dim_perc_avg = product_health_dim_perc_avg;
        this.product_inspiration_dim_perc_avg = product_inspiration_dim_perc_avg;
        this.product_keto_avg = product_keto_avg;
        this.product_paleo_avg = product_paleo_avg;
        this.product_price_dim_perc_avg = product_price_dim_perc_avg;
        this.product_quality_dim_perc_avg = product_quality_dim_perc_avg;
        this.product_vegan_avg = product_vegan_avg;
        this.updated = updated;
    }

    public String getAlt_text() {
        return alt_text;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public String[] getDestination_upcs() {
        return destination_upcs;
    }

    public Float getProduct_convenience_dim_perc_avg() {
        return product_convenience_dim_perc_avg;
    }

    public Float getProduct_health_dim_perc_avg() {
        return product_health_dim_perc_avg;
    }

    public Float getProduct_inspiration_dim_perc_avg() {
        return product_inspiration_dim_perc_avg;
    }

    public Float getProduct_keto_avg() {
        return product_keto_avg;
    }

    public Float getProduct_paleo_avg() {
        return product_paleo_avg;
    }

    public Float getProduct_price_dim_perc_avg() {
        return product_price_dim_perc_avg;
    }

    public Float getProduct_quality_dim_perc_avg() {
        return product_quality_dim_perc_avg;
    }

    public Float getProduct_vegan_avg() {
        return product_vegan_avg;
    }

    public String getUpdated() {
        return updated;
    }
}
