package com.perekupapp.resources;

import java.util.function.BinaryOperator;

import static java.lang.String.format;

public class Constants {

    public class Texts {
        public static final String SKODA_AD_ID = "33263024";
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
