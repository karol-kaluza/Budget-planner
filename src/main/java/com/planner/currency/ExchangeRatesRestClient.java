package com.planner.CurrencyConverter;

import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExchangeRatesRestClient {

    final static Logger logger = Logger.getLogger(ExchangeRatesRestClient.class);
    private String data;
    private HttpClient client = HttpClient.newHttpClient();
    @Value("${exchangeRestURI}")
    private String restURI;


    public ExchangeRatesRestClient() {
        setData(getDataFromAPI());
    }

    @VisibleForTesting
    String getDataFromAPI() {
        HttpRequest request = HttpRequest.newBuilder()
                //todo move to app props
                .uri(URI.create(restURI))
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
