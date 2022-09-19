package com.perekupapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perekupapp.models.Auto;
import com.perekupapp.reporistories.UsedCarsRepository;
import com.perekupapp.resources.Constants;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/used-autos")
public class UsedAutosController {

    @Autowired
    private UsedCarsRepository usedCarsRepository;

    @GetMapping("/all")
    public Collection<Auto> getAllAutos() {
         return (Collection<Auto>) usedCarsRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("/get-test")
    private Auto getTest() {
        String response = Unirest.get("https://developers.ria.com/auto/info?api_key=jQB90wUws74INYaGWkEG4U9E2pBAaw6JhfZlKFo5&auto_id=33263024").asString().getBody();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Auto.class);
    }
}
