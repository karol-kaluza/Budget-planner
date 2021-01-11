package com.planner.CurrencyConverter;

import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRatesAPI {

    final static Logger logger = Logger.getLogger(ExchangeRatesAPI.class);
    private String data;

    public ExchangeRatesAPI() {
        setData(getDataFromAPI());
    }

    @VisibleForTesting
    String getDataFromAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("HTTPRequest status code: " + response.statusCode());
            return response.body();
        } catch (Exception e) {
            logger.error("Connection to api error: ", e);
        }
        return "";
    }

    public String getData() {
        return data;
    }

    private void setData(String data) {
        this.data = data;
    }
}
