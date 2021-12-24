package com.johnsonwang.ssia.config;

import com.johnsonwang.ssia.handler.CustomAuthenticationFailureHandler;
import com.johnsonwang.ssia.handler.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableAsync
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public InitializingBean initializingBean() {
        return () -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().successHandler(this.authenticationSuccessHandler)
                        .failureHandler(this.authenticationFailureHandler).and().httpBasic();

        http.authorizeRequests().anyRequest().authenticated();
    }
}
