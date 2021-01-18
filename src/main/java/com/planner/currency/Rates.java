package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Rates {
    private Map<String, Double> data;
    final static Logger logger = Logger.getLogger(Rates.class);

    private ExchangeRatesRestClient restClient;

    @Autowired
    public Rates(ExchangeRatesRestClient restClient) {
        this.restClient = restClient;
    }

    @VisibleForTesting
    Rates() {
        String rawData = restClient.getDataFromAPI();
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
