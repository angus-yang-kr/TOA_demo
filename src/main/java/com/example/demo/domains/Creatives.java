package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creatives {
    private final String id;
    private final Integer clearingPrice;
    private final Integer slotId;
    private final String placementId;

    public Creatives(@JsonProperty("id") String id,
                     @JsonProperty("clearingPrice") Integer clearingPrice,
                     @JsonProperty("slotId") Integer slotId,
                     @JsonProperty("placementId") String placementId) {
        this.id = id;
        this.clearingPrice = clearingPrice;
        this.slotId = slotId;
        this.placementId = placementId;
    }

    public String getId() {
        return id;
    }

    public Integer getClearingPrice() {
        return clearingPrice;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public String getPlacementId() {
        return placementId;
    }
}
