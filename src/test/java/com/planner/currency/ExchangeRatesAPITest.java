package com.planner.currency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ExchangeRatesAPITest {

    @Autowired
    ExchangeRatesRestClient restClient;

    @Test
    public void getDataFromApi() {
        //given
        String result;
        //when
        result = restClient.getDataFromAPI();
        //then
        assertTrue(result.getClass() == String.class);
    }
}