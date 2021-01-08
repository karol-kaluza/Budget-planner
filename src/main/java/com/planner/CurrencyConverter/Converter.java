package com.planner.CurrencyConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Converter {

    final static Logger logger = Logger.getLogger(Converter.class);

    public enum Currency {
        EUR, USD, CHF, GBP, PLN
    }

    public Double getRate(Currency currency) {
        return getRateFromRates(currency,
                convertToMap(getDataFromAPI(), new ObjectMapper()));
    }

    protected String getDataFromAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("HTTPRequest status code: " + response.statusCode());
            return response.body();
        } catch (Exception e) {
            logger.error("Connection to api error: ", e);
        }
        return "";
    }

    @VisibleForTesting
    Double getRateFromRates(Currency currency, Map<String, Double> rates) {
        if (rates == null) {
            return 1.0;
        }
        Double rate = rates.get(currency.toString());
        logger.info("Rate for " + currency + ": " + rate);
        return rate;
    }

    protected Map<String, Double> convertToMap(String responseBody, ObjectMapper mapper) {
        try {
            Map<String, Map<String, Double>> map = mapper.readValue(responseBody, Map.class);
            return map.get("rates");
        } catch (Exception e) {
            logger.error("Cannot parse JSON to map");
        }
        return null;
    }
}
