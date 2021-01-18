package com.planner.currency;

import com.planner.currency.config.AppProps;
import com.planner.currency.config.RestUrlConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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
    private String restUrl;
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;



    public ExchangeRatesRestClient() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RestUrlConfig.class);
        restUrl = context.getBean(AppProps.class).getRestUrl();
        setData(getDataFromAPI());
    }

    @VisibleForTesting
    public String getDataFromAPI() {
        request = HttpRequest.newBuilder()
                //todo move to app props
                .uri(URI.create(restUrl))
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
