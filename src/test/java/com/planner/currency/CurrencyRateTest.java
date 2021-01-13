package com.planner.CurrencyConverter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateTest {

    @Test
    public void getProperRate() {
        //given
        CurrencyRate subject = new CurrencyRate();
        //when
        //then
        assertNotNull( subject.getRates());
    }
}