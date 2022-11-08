package com.perekupapp.services;

import com.perekupapp.resources.Constants;
import kong.unirest.Unirest;
import lombok.experimental.UtilityClass;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

import static com.perekupapp.resources.Constants.Links.RIA_SEARCH_URL;
import static com.perekupapp.resources.Constants.Links.USED_AUTOS;

@UtilityClass
public class Manager {

    @GetMapping("go-debug")
    public static String goDebug() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization:", "Authorization: Bearer " + Constants.ApiInfo.TOKEN);
        headers.put("Accept", "application/json");
        String response = Unirest.get(RIA_SEARCH_URL + USED_AUTOS).headers(headers).getBody().get().toString();
        System.out.println(headers);
        return response;
    }

    public static String mapCarMakeToId(String make) {
        Constants.CarIds carIds = new Constants.CarIds();
        return carIds.makeIds.get(make);
    }

    public static String mapCarModelToId(String model) {
        Constants.ModelIds modelIds = new Constants.ModelIds();
        return modelIds.modelIds.get(model);
    }
}
