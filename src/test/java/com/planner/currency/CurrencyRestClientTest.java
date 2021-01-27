package com.planner.currency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyRestClientTest {

    @Mock
    private HttpClient client;
    @InjectMocks
    private CurrencyRestClient subject;

    @Test
    void getDataFromAPIWithWrongUrl() throws IOException, InterruptedException {
        //given
        String expected = "";
        String actual;
        given(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).willReturn(null);
        //when
        actual = subject.getDataFromAPI();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyString_ifHttpClientRespondsWith404() throws IOException, InterruptedException {
        //given
        String result;
        //when
        when(client.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class))).thenThrow(new IOException());
        result = subject.getDataFromAPI();
        //then
        assertEquals("", result);
    }
}