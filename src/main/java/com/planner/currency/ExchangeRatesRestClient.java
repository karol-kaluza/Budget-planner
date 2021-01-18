package com.planner.currency;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class ExchangeRatesRestClient {

    @Getter
    @Setter
    private String data;
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;

//    @Value("${exchangeRestURI}")
    private String restURI = "https://api.exchangeratesapi.io/latest?base=PLN";

    public ExchangeRatesRestClient() {
        setData(getDataFromAPI());
    }

    @VisibleForTesting
    public String getDataFromAPI() {
        request = HttpRequest.newBuilder()
                //todo move to app props
                .uri(URI.create(restURI))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("HTTPRequest status code: " + response.statusCode());
            return response.body();
        } catch (Exception e) {
            log.error("Connection to api error: ", e);
        }
        return "";
    }
}
