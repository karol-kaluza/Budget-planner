package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;

import java.util.Map;

@Slf4j

public class Rates {

    private Map<String, Double> data;

    @VisibleForTesting
    Rates() {
        String rawData = new ExchangeRatesRestClient().getDataFromAPI();
        DataConverter util = new DataConverter();
        this.data = util.convertToMap(rawData, new ObjectMapper());
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
