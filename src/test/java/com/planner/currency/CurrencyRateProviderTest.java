package com.planner.currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CurrencyRateProviderTest {

    @Test
    public void getProperRate() {
        //given
        CurrencyRateProvider subject = new CurrencyRateProvider();
        //when
        //then
        assertNotNull( subject.getRates());
    }
}