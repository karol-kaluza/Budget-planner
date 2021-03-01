package com.planner.currency;

import org.assertj.core.util.VisibleForTesting;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRestClient {

    private final RestTemplate restTemplate;

    public CurrencyRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @VisibleForTesting
    public String getDataFromAPI(String chosenCurrency) {
        return restTemplate.getForObject("/latest?base=" + chosenCurrency, String.class);
    }
//    public String getDataFromAPI() {
//        return restTemplate.getForObject("/latest?base=EUR", String.class);
//    }
}