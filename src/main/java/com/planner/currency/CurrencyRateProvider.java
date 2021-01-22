package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CurrencyRateProvider {

    ExchangeRatesRestClient client;
    HttpResponseToCurrencyMapConverter converter;
    ObjectMapper objectMapper;
    //TODO add depenency injection

    @Autowired
    public CurrencyRateProvider(ExchangeRatesRestClient client,
                                HttpResponseToCurrencyMapConverter converter,
                                ObjectMapper objectMapper) {
        this.client = client;
        this.converter = converter;
        this.objectMapper = objectMapper;
    }

    public double getRate(Currency currency) {
        String jsonResponse = client.getDataFromAPI();
        Map<String, Double> currencies = converter.convert(jsonResponse, objectMapper);
        return currencies.get(currency);
    }
}
