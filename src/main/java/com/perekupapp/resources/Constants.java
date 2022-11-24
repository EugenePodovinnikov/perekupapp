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
        public static final String COUNT_PAGE_20 = "countpage=20";
        public static final String SORT_BY_ASC = "sort[0]=1";
        public static final String ORDER_BY_ASC = "&order_by=2";
    }

    public static class CarIds {
        public Map<String, String> makeIds = new HashMap<>();

        {
            makeIds.put("Alfa Romeo", "2");
            makeIds.put("Mercedes", "48");
            makeIds.put("Audi", "6");
            makeIds.put("Toyota", "79");
            makeIds.put("Volkswagen", "84");
            makeIds.put("BMW", "9");
            makeIds.put("Porsche", "59");
            makeIds.put("Skoda", "70");
            makeIds.put("Ford", "24");
            makeIds.put("Renault", "62");
            makeIds.put("Nissan", "55");
            makeIds.put("Mitsubishi", "52");
            makeIds.put("Honda", "28");
            makeIds.put("Chevrolet", "13");
            makeIds.put("Jeep", "32");
            makeIds.put("Hyundai", "29");
            makeIds.put("Peugeot", "58");
            makeIds.put("Volvo", "85");
            makeIds.put("Daewoo", "55");
            makeIds.put("Opel", "56");
            makeIds.put("ВАЗ", "88");
            makeIds.put("Fiat", "23");
            makeIds.put("Mazda", "47");
            makeIds.put("Subaru", "75");
            makeIds.put("Lexus", "38");
            makeIds.put("Suzuki", "76");
            makeIds.put("Kia", "33");
            makeIds.put("Land Rover", "37");

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
