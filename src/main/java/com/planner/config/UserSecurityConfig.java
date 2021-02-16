package com.planner.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*").permitAll()
                .antMatchers("/expense/*").permitAll()
                .antMatchers("/user/*/*").permitAll()
                .antMatchers("/user/*").permitAll()
                .anyRequest().authenticated()
                .and()
                // TODO: 10/02/2021 login page redirection
                .oauth2Login()
                .and()
                .logout(l -> l.logoutSuccessUrl("/goodbye").permitAll())
                .csrf(c -> c
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                );
    }

}
