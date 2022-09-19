package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

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
    private String vin;

    @JsonProperty
    private String plateNumber;

    @JsonProperty
    @ElementCollection
    private List<String> prices;

    @JsonProperty
    private String description;
}
