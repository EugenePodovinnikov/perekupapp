package com.perekupapp.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perekupapp.models.Auto;
import com.perekupapp.models.Make;
import com.perekupapp.models.SearchResult;
import com.perekupapp.reporistories.UsedCarsRepository;
import com.perekupapp.resources.Constants.PriceThreshold;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.perekupapp.resources.Constants.ApiInfo.TOKEN;
import static com.perekupapp.resources.Constants.Links.RIA_SEARCH_URL;
import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/used-autos")
public class UsedAutosController {

    @Autowired
    private UsedCarsRepository usedCarsRepository;

    @SneakyThrows
    @GetMapping("/all")
    public SearchResult getAllAutos() {
        String response = Unirest.get(RIA_SEARCH_URL + TOKEN).asString().getBody();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        SearchResult searchResult = mapper.readValue(response, SearchResult.class);
        System.out.println(searchResult.getResult().toPrettyString());
        return mapper.readValue(response, SearchResult.class);
    }

    @SneakyThrows
    @GetMapping("/get-test")
    public Auto getTest() {
        String response = Unirest.get("https://developers.ria.com/auto/info?api_key=jQB90wUws74INYaGWkEG4U9E2pBAaw6JhfZlKFo5&auto_id=33263024").asString().getBody();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return mapper.readValue(response, Auto.class);
    }

    public List<Auto> getAutoByPriceAndYear(PriceThreshold maxPrice, Make make, LocalDate from, LocalDate till) {
        BiFunction<LocalDate, LocalDate, String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        Function<Make, String> makeParameter = s -> format("marka_id[0]=%s", s);
        Function<PriceThreshold, String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String response = Unirest.get(RIA_SEARCH_URL + TOKEN + yearParameter.apply(from, till) + makeParameter.apply(make) + priceParameter.apply(maxPrice)).asJson().getBody().toPrettyString();

    }






}
