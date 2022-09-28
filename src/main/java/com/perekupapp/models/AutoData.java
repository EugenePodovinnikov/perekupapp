package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutoData {

    @JsonProperty
    private String description;

    @JsonProperty
    private String year;

    @JsonProperty
    private String race;

    @JsonProperty
    private String fuelName;

    @JsonProperty
    private String gearBoxName;

    @JsonProperty
    private String driveName;
}
