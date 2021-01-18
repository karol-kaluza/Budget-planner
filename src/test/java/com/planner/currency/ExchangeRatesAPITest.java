package com.planner.currency;

import com.planner.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
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