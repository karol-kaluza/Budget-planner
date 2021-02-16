package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyRateProvider {

    CurrencyRestClient client;
    HttpResponseToCurrencyMapConverter converter;
    ObjectMapper objectMapper;

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
