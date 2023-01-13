package com.tjv.project.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class BookclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }
    @Bean
    SecurityFilterChain securityConfig(HttpSecurity security) throws Exception {
        security.cors()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .oauth2ResourceServer().jwt();
        return security.build();
    }

}