package com.perekupapp.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perekupapp.models.CarAdvert;
import com.perekupapp.reporistories.UsedCarsRepository;
import kong.unirest.Unirest;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static com.perekupapp.resources.Constants.ApiInfo.TOKEN;
import static com.perekupapp.resources.Constants.Links.AUTO_PAGE_URL;
import static com.perekupapp.resources.Constants.Links.RIA_SEARCH_URL;
import static com.perekupapp.resources.Constants.Texts.*;
import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/used-autos")
public class UsedAutosController {

    private static final Logger logger = LogManager.getRootLogger();

    @Autowired
    private UsedCarsRepository usedCarsRepository;
    private List<CarAdvert> searchResults;

    @SneakyThrows
    @GetMapping("/all")
    public List<CarAdvert> getAllAutos() {
        String requestUrl = RIA_SEARCH_URL + TOKEN;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        searchResults = getCarAdverts(requestUrl, mapper);
        return searchResults;
    }

    @SneakyThrows
    @GetMapping("/get-test")
    public CarAdvert getTest() {
        String response = Unirest.get("https://developers.ria.com/auto/info?api_key=jQB90wUws74INYaGWkEG4U9E2pBAaw6JhfZlKFo5&auto_id=33263024").asString().getBody();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        return mapper.readValue(response, CarAdvert.class);
    }

    @SneakyThrows
    @GetMapping("/get-by-id")
    public String getById(@RequestParam String id) {
        String requestUrl = format(AUTO_PAGE_URL, TOKEN, id);
        return Unirest.get(requestUrl).asJson().getBody().toPrettyString();
    }

    @SneakyThrows
    @GetMapping("/get-by-price-year-and-make")
    public List<CarAdvert> getAutoByPriceYearMakeAndModel(@RequestParam String maxPrice, @RequestParam  String make, @RequestParam  String yearFrom, @RequestParam String yearTill) {
        BinaryOperator<String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        UnaryOperator<String> makeParameter = s -> format("marka_id[0]=%s", s);
        UnaryOperator<String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String requestUrl = RIA_SEARCH_URL + TOKEN + "&" + yearParameter.apply(yearFrom, yearTill) + "&" + makeParameter.apply(make) + "&" + priceParameter.apply(maxPrice);
        logger.info(format(PERFORMING_REQUEST, requestUrl));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        searchResults = getCarAdverts(requestUrl, mapper);
        return searchResults;
    }



    @SneakyThrows
    @GetMapping("/get-by-price-year-make-and-model")
    public List<CarAdvert> getAutoByPriceYearMakeAndModel(@RequestParam String maxPrice, @RequestParam  String make, String model, @RequestParam  String yearFrom, @RequestParam String yearTill) {
        BinaryOperator<String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        UnaryOperator<String> makeParameter = s -> format("marka_id[0]=%s", s);
        UnaryOperator<String> modelParameter = m -> format("model_id[0]=%s", m);
        UnaryOperator<String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String requestUrl = RIA_SEARCH_URL + TOKEN + "&" + yearParameter.apply(yearFrom, yearTill) + "&" + makeParameter.apply(make) + "&" + modelParameter.apply(model) + "&" + priceParameter.apply(maxPrice);
        logger.info(format(PERFORMING_REQUEST, requestUrl));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        searchResults = getCarAdverts(requestUrl, mapper);
        return searchResults;
    }


    @SneakyThrows
    @GetMapping("/get-by-price-and-year")
    public List<CarAdvert> getAutoByPriceAndYear(@RequestParam String maxPrice, @RequestParam  String yearFrom, @RequestParam String yearTill) {
        BinaryOperator<String> yearParameter = (a, b) -> format("s_yers[0]=%s&po_yers[0]=%s", a, b);
        UnaryOperator<String> priceParameter = c -> format("price_ot=0&price_do=%s", c);
        String requestUrl = RIA_SEARCH_URL + TOKEN + "&" + yearParameter.apply(yearFrom, yearTill) + "&" + priceParameter.apply(maxPrice);
        logger.info(format(PERFORMING_REQUEST, requestUrl));
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        searchResults = getCarAdverts(requestUrl, mapper);
        return searchResults;
    }

    @SuppressWarnings("unchecked")
    private List<CarAdvert> getCarAdverts(String requestUrl, ObjectMapper mapper) {
        List<String> ids = Unirest.get(requestUrl).asJson()
                .getBody()
                .getObject()
                .getJSONObject(RESULT)
                .getJSONObject(SEARCH_RESULT)
                .getJSONArray(IDS).toList();
        logger.info(format(FOUND_N_RESULTS, ids.size()));
        return ids.stream().map(id -> {
            try {
                return mapper.readValue(getById(id), CarAdvert.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).peek(e -> logger.info(format(ADVERT_CREATED, e))).collect(Collectors.toList());
    }

    @PostMapping("save-all")
    public void saveAllResultsToDatabase() {
        usedCarsRepository.saveAll(searchResults);
    }

    @PutMapping("save-by-id")
    public void saveToDatabaseById(@RequestParam String id) {
        List<CarAdvert> result = searchResults.stream().filter(c -> c.getLinkToView().contains(id)).collect(Collectors.toList());
        usedCarsRepository.save(result.get(0));
    }
}
