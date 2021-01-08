package com.planner.CurrencyConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    public void convertToMap() {
        // given
        String testInput = "{\"rates\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
        Converter subject = new Converter();
        // when
        Map<String, Double> actual = subject.convertToMap(testInput, new ObjectMapper());
        // then
        assertEquals(actual.get("CUR1"), "12");
    }

    @Test
    public void getRateFromRates() {
        //given
        Map<String, Double> ratesMap = new HashMap<>();
        ratesMap.put("GBP", 2.1);
        Converter subject = new Converter();
        double actual;
        double expected = 2.1;
        //when
        actual = subject.getRateFromRates(Converter.Currency.GBP, ratesMap);
        //then
        assertEquals(actual, expected);
    }

    @Test
    public void forNullMapGetRateFromRatesReturnsOne() {
        //given
        Map<String, Double> ratesMap = null;
        Converter subject = new Converter();
        double actual;
        double expected = 1.0;
        //when
        actual = subject.getRateFromRates(Converter.Currency.CHF, ratesMap);
        //then
        assertEquals(actual, expected);
    }

    @Test
    public void convertToMapReturnsNullWithEmptyStringArg() {
        // given
        String testInput = "";
        Converter subject = new Converter();
        // when
        Map<String, Double> actual = subject.convertToMap(testInput, new ObjectMapper());
        // then
        assertNull(actual);
    }

    @Test
    public void convertToMapReturnsNullWithWrongStringArg() {
        // given
        String testInput = "{\"rate\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
        Converter subject = new Converter();
        // when
        Map<String, Double> actual = subject.convertToMap(testInput, new ObjectMapper());
        // then
        assertNull(actual);
    }

    @Test
    public void getDataFromApi() {
        //given
        Converter subject = new Converter();
        String result;
        //when
        result = subject.getDataFromAPI();
        //then
        assertTrue(result.getClass() == String.class);
    }

    @Test
    public void getProperRate() {
        //given
        Converter subject = new Converter();
        double result;
        //when
        result = subject.getRate(Converter.Currency.GBP);
        //then
        assertNotNull(result);
    }
}