package com.planner.CurrencyConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.Map;

public class Rates {
    private final Map<String, Double> data;
    final static Logger logger = Logger.getLogger(Rates.class);

    double getRate(Currency currency) {
        if (data == null) {
            return 1.0;
        }
        Double rate = data.get(currency.toString());
        logger.info("Rate for " + currency + ": " + rate);
        return rate;
    }

    Rates() {
        String rawData = new ExchangeRatesAPI().getData();
        DataConverter util = new DataConverter();
        this.data = util.convertToMap(rawData, new ObjectMapper());
    }
}
