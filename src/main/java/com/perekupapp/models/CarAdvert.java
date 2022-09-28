package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

import static com.perekupapp.resources.Constants.Links.AUTO_RIA_BASE_URL;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class CarAdvert {

    @Id
    @JsonProperty
    @Column(name  = "id")
    private long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private String linkToView;

    public String getLinkToView() {
        return AUTO_RIA_BASE_URL + linkToView;
    }

    @JsonProperty
    private String userId;

    @JsonProperty
    private String locationCityName;

    @JsonProperty
    private String markName;

    @JsonProperty
    private String modelName;

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

    @Override
    public String toString() {
        return "CarAdvert{" +
                "title='" + title + '\'' +
                ", linkToView='" + linkToView + '\'' +
                ", locationCityName='" + locationCityName + '\'' +
                ", markName='" + markName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", USD='" + USD + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
