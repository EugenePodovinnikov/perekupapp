package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static com.perekupapp.resources.Constants.Links.AUTO_RIA_BASE_URL;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class CarAdvert {

    @Id
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

    @JsonProperty("USD")
    private String priceUsd;

    @Override
    public String toString() {
        return "CarAdvert{" +
                "title='" + title + '\'' +
                ", linkToView='" + linkToView + '\'' +
                ", locationCityName='" + locationCityName + '\'' +
                ", markName='" + markName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", priceUsd='" + priceUsd + '\'' +
                '}';
    }
}
