package com.planner.currency.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class RestUrlConfig {

    @Autowired
    Environment env;

    @Bean
    AppProps appProps() {
        AppProps bean = new AppProps();
        bean.setRestUrl(env.getProperty("exchangeRestURI"));
        return bean;
    }
}
