package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CurrencyRateProvider {

    CurrencyRestClient client;
    HttpResponseToCurrencyMapConverter converter;
    ObjectMapper objectMapper;

    @Autowired
    public CurrencyRateProvider(CurrencyRestClient client,
                                HttpResponseToCurrencyMapConverter converter,
                                ObjectMapper objectMapper) {
        this.client = client;
        this.converter = converter;
        this.objectMapper = objectMapper;
    }

    public double getRate(Currency currency) {
        String jsonResponse = client.getDataFromAPI();
        Map<String, Double> currencies = converter.convert(jsonResponse, objectMapper);
        if (currencies == null || currencies.size() == 0) {
            return -1;
        }
        return currencies.get(currency.toString());
    }

    public enum Currency {
        EUR, USD, CHF, GBP, PLN;
    }
}
