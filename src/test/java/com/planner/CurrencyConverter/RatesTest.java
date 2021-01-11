package com.planner.CurrencyConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RatesTest {

    Rates subject = new Rates();

    @Test
    public void getRate() {
        //given
        double expected;
        //when
        expected = subject.getRate(Currency.EUR);
        //then
        assertNotNull(expected);
    }

    @Test
    public void forNullDataGetRateReturnsOne() {
        //given
        double actual;
        double expected = 1.0;
        //when
        subject.setData(null);
        actual = subject.getRate(Currency.CHF);
        //then
        assertEquals(actual, expected);
    }


}