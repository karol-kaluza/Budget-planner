package com.planner.currency;

import com.planner.config.AppProps;
import com.planner.config.RestUrlConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Service
@Getter
@Setter
public class CurrencyRestClient {

    private final String restUrl;
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;


    public CurrencyRestClient() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RestUrlConfig.class);
        restUrl = context.getBean(AppProps.class).getRestUrl();
    }


    @VisibleForTesting
    public String getDataFromAPI() {
        setRequest(HttpRequest.newBuilder()
                .uri(URI.create(getRestUrl()))
                .build());
        try {
            HttpResponse<String> response = client.send(getRequest(), HttpResponse.BodyHandlers.ofString());
            log.info("HTTPRequest status code: " + response.statusCode());
            return response.body();
        } catch (Exception e) {
            log.error("Connection to api error: ", e);
        }
        return "";
    }
}
