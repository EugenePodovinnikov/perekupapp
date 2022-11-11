package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private String driveName;

    @JsonProperty
    private String autoId;
}
