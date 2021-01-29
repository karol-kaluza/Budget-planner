package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
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
        log.info("Current rate for: " + currency + " is " + currencies.get(currency.toString()));
        return currencies.get(currency.toString());
    }

    public enum Currency {
        EUR, USD, CHF, GBP, PLN;
    }
}
