package com.perekupapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static com.perekupapp.resources.Constants.Links.AUTO_RIA_BASE_URL;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarAdvert {

    @JsonProperty
    private AutoData autoData;

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

    @JsonProperty("VIN")
    private String vin;

    @Override
    public String toString() {
        return "CarAdvert{" +
                "autoData=" + autoData +
                ", title='" + title + '\'' +
                ", linkToView='" + linkToView + '\'' +
                ", userId='" + userId + '\'' +
                ", locationCityName='" + locationCityName + '\'' +
                ", markName='" + markName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", priceUsd='" + priceUsd + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
