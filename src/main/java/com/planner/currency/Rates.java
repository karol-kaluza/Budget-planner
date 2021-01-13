package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;

import java.util.Map;

public class Rates {
    private Map<String, Double> data;
    final static Logger logger = Logger.getLogger(Rates.class);

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
        logger.info("Rate for " + currency + ": " + rate);
        return rate;
    }

    @VisibleForTesting
    void setData(Map<String, Double> data) {
        this.data = data;
    }
}
