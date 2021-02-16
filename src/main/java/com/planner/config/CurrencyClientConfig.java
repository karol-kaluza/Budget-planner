package com.planner.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyClientConfig {

    @Bean
    public RestTemplate currencyClient(@Value("${exchange.rest.url}") String restUrl,
                                       RestTemplateBuilder builder) {
        return builder
                .rootUri(restUrl)
                .build();
    }
}
