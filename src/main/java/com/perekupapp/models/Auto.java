package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auto {

    @Id
    @JsonProperty
    @Column(name  = "id")
    private long id;

    @JsonProperty
    private String userId;

    @JsonProperty
    private String locationCityName;

    @JsonProperty
    private String markName;

    @JsonProperty
    private String modelName;

    @JsonProperty
    private String linkToView;

    @JsonProperty
    private String VIN;

    @JsonProperty
    private String plateNumber;

    @JsonProperty
    private String USD;

    @JsonProperty
    private String UAH;

    @JsonProperty
    private String EUR;

    @JsonProperty
    private String description;

    @JsonProperty
    private int year;

    @JsonProperty
    private int raceInt;

//    @JsonProperty
//    @ElementCollection
//    private List<String> photoData;
}
