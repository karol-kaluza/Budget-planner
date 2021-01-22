package com.planner.currency;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ExchangeRatesRestClientTest {

    @Mock
    HttpClient httpClient;

    @InjectMocks
    ExchangeRatesRestClient exchangeRatesRestClient;

    void shouldReturnEmptyString_ifHttpClientRespondsWith404() {
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenThrow(new IOException());

        String result = exchangeRatesRestClient.getDataFromAPI();

        assertEquals("", result);
    }

    void shouldReturnCorrectValue_ifHttpClientRespondsWithValidREsponse() {
        when(httpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenReturn("json");

        String result = exchangeRatesRestClient.getDataFromAPI();

        assertEquals("", result);
    }
}