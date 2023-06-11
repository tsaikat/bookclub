package com.tjv.project.bookclub;

import com.tjv.project.bookclub.config.CustomCorsConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class BookclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }

    @Bean
    SecurityFilterChain securityConfig(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/swagger-ui/index.html",
                        "/swagger-ui/**", "/swagger-resources/**", "/swagger-resources",
                        "/api-docs/**", "/proxy/**", "/v3/api-docs/**")
                .permitAll()
                .and()
                .cors()
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