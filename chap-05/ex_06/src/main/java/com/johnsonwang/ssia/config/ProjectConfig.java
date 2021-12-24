package com.johnsonwang.ssia.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableAsync
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public InitializingBean initializingBean() {
        return () -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic(c -> {
            c.realmName("OTHER");
            c.authenticationEntryPoint(new CustomEntryPoint());
        });

        http.authorizeRequests().anyRequest().authenticated();
    }
}
