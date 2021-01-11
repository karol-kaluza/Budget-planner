//package com.planner.CurrencyConverter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.planner.CurrencyConverter.ExchangeRatesAPI.getDataFromAPI;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ConverterTest {
//

//    @Test
//    public void getRateFromRates() {
//        //given
//        Map<String, Double> ratesMap = new HashMap<>();
//        ratesMap.put("GBP", 2.1);
//        CurrencyRate subject = new CurrencyRate();
//        double actual;
//        double expected = 2.1;
//        //when
//        actual = subject.getRateFromRates(CurrencyRate.Currency.GBP, ratesMap);
//        //then
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void forNullMapGetRateFromRatesReturnsOne() {
//        //given
//        Map<String, Double> ratesMap = null;
//        CurrencyRate subject = new CurrencyRate();
//        double actual;
//        double expected = 1.0;
//        //when
//        actual = subject.getRateFromRates(CurrencyRate.Currency.CHF, ratesMap);
//        //then
//        assertEquals(actual, expected);
//    }
//

//
//    @Test
//    public void getProperRate() {
//        //given
//        CurrencyRate subject = new CurrencyRate();
//        double result;
//        //when
//        result = subject.getRate(CurrencyRate.Currency.GBP);
//        //then
//        assertNotNull(result);
//    }
//}