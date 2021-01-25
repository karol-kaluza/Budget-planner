//package com.planner.currency;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class HttpResponseToCurrencyMapConverterTest {
//
//    @Test
//    public void convertToMap() {
//        // given
//        String testInput = "{\"rates\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
//        HttpResponseToCurrencyMapConverter subject = new HttpResponseToCurrencyMapConverter();
//        // when
//        Map<String, Double> actual = subject.convert(testInput, new ObjectMapper());
//        // then
//        assertEquals(actual.get("CUR1"), "12");
//    }
//
//    @Test
//    public void convertToMapReturnsNullWithEmptyStringArg() {
//        // given
//        String testInput = "";
//        HttpResponseToCurrencyMapConverter subject = new HttpResponseToCurrencyMapConverter();
//        // when
//        Map<String, Double> actual = subject.convert(testInput, new ObjectMapper());
//        // then
//        assertNull(actual);
//    }
//
//    @Test
//    public void convertToMapReturnsNullWithWrongStringArg() {
//        // given
//        String testInput = "{\"rate\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
//        HttpResponseToCurrencyMapConverter subject = new HttpResponseToCurrencyMapConverter();
//        // when
//        Map<String, Double> actual = subject.convert(testInput, new ObjectMapper());
//        // then
//        assertNull(actual);
//    }
//}