package com.perekupapp.resources;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public class Texts {
        public static final String SKODA_AD_ID = "33263024";
        public static final String PERFORMING_REQUEST = "Performing request to: %s";
        public static final String ALL_MODELS = "model_id[1]=0";
        public static final String RESULT = "result";
        public static final String SEARCH_RESULT = "search_result";
        public static final String IDS = "ids";
        public static final String ADVERT_CREATED = "Advert object created: %s";
        public static final String FOUND_N_RESULTS = "Found %d results";
    }

    public static class CarIds {
        public Map<String, String> makeIds = new HashMap<>();
        {
            makeIds.put("Alfa Romeo", "2");
            makeIds.put("Toyota", "79");
            makeIds.put("Volkswagen", "84");
            makeIds.put("BMW", "9");
        }
    }

    public static class ModelIds {
        public Map<String, String> modelIds = new HashMap<>();
        {
            modelIds.put("Tiguan", "2692");
            modelIds.put("F10", "32647");
        }
    }

    public class VolkswagenModelIds {
        public static final String TIGUAN = "2692";
    }

    public class Bmw_Models {
        public static final String F10_528 = "32647";
    }

    public class ApiInfo {
        public static final String TOKEN = "jQB90wUws74INYaGWkEG4U9E2pBAaw6JhfZlKFo5";
    }

    public class Links {
        public static final String RIA_SEARCH_URL = "https://developers.ria.com/auto/search?api_key=";
        public static final String USED_AUTOS = "/auto/used/autos/api?api_key=";
        public static final String AUTO_SEARCH = "/auto/search";
        public static final String NEW_AUTOS = "/auto/new/autos";
        public static final String AUTO_PAGE_URL = "https://developers.ria.com/auto/info?api_key=%s&auto_id=%s";
        public static final String AUTO_RIA_BASE_URL = "https://auto.ria.com";
        public static final String PHOTOS = "https://developers.ria.com/auto/fotos/%s?api_key=" + ApiInfo.TOKEN;
    }

    public class Parameters {
        public static final String PASSENGER_CAR = "category_id=1";
    }

    public class Functions {
    }

    public class PriceThreshold {
        public static final int ONE_THOUSAND = 1000;
        public static final int TWO_THOUSAND = 2000;
        public static final int THREE_THOUSAND = 3000;
        public static final int FOUR_THOUSAND = 4000;
        public static final int FIVE_THOUSAND = 5000;
        public static final int SIX_THOUSAND = 6000;
        public static final int SEVEN_THOUSAND = 7000;
        public static final int EIGHT_THOUSAND = 8000;
    }
}
