package com.planner.CurrencyConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRatesAPITest {

    @Test
    public void getDataFromApi() {
        //given
        String result;
        //when
        result = new ExchangeRatesRestClient().getDataFromAPI();
        //then
        assertTrue(result.getClass() == String.class);
    }
}