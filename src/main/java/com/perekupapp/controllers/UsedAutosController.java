package com.perekupapp.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perekupapp.models.Auto;
import com.perekupapp.models.SearchResult;
import com.perekupapp.reporistories.UsedCarsRepository;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

import static com.perekupapp.resources.Constants.ApiInfo.TOKEN;
import static com.perekupapp.resources.Constants.Links.RIA_SEARCH_URL;
import static com.perekupapp.resources.Constants.Texts.PERFORMING_REQUEST;
import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/used-autos")
public class UsedAutosController {

    private static final Logger logger = LogManager.getRootLogger();

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

    @SneakyThrows
    @GetMapping("/get-by-price-year-and-make")
    public String getAutoByPriceAndYear(@RequestParam String maxPrice, @RequestParam  String make, @RequestParam  String yearFrom, @RequestParam String yearTill) {
        BinaryOperator<String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        UnaryOperator<String> makeParameter = s -> format("marka_id[0]=%s", s);
        UnaryOperator<String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String requestUrl = RIA_SEARCH_URL + TOKEN + "&" + yearParameter.apply(yearFrom, yearTill) + "&" + makeParameter.apply(make) + "&" + priceParameter.apply(maxPrice);
        logger.info(format(PERFORMING_REQUEST, requestUrl));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return Unirest.get(requestUrl).asJson().getBody().toPrettyString();
//        return List.of(mapper.readValue(Unirest.get(requestUrl).asJson().getBody().getObject().getString("search_result"), SearchResult.class));
    }

    @SneakyThrows
    @GetMapping("/get-by-price-and-year")
    public String getAutoByPriceAndYear(@RequestParam String maxPrice, @RequestParam  String yearFrom, @RequestParam String yearTill) {
        BinaryOperator<String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        UnaryOperator<String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String requestUrl = RIA_SEARCH_URL + TOKEN + "&" + yearParameter.apply(yearFrom, yearTill) + "&" + priceParameter.apply(maxPrice);
        logger.info(format(PERFORMING_REQUEST, requestUrl));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return Unirest.get(requestUrl).asJson().getBody().toPrettyString();
//        return List.of(mapper.readValue(Unirest.get(requestUrl).asJson().getBody().getObject().getString("search_result"), SearchResult.class));
    }
}
