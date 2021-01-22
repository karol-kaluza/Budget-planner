package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Rates {

    private Map<String, Double> data;

    @VisibleForTesting
    Rates() {
        data = new HashMap<>();
    }

    public void fillCurrencyRatesFromService() {
        String rawData = new ExchangeRatesRestClient().getDataFromAPI();
        //TODO make converter field, inject it with DI. Change the name
        HttpResponseToCurrencyMapConverter util = new HttpResponseToCurrencyMapConverter();
        this.data = util.convert(rawData, new ObjectMapper());
    }

    @VisibleForTesting
    double getRate(Currency currency) {
        if (data == null) {
            return 1.0;
        }
        Double rate = data.get(currency.toString());
        log.info("Rate for " + currency + ": " + rate);
        return rate;
    }

    @VisibleForTesting
    void setData(Map<String, Double> data) {
        this.data = data;
    }
}
