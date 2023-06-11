package com.tjv.project.bookclub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomCorsConfigurationSource {

    private final Environment env;

    @Autowired
    public CustomCorsConfigurationSource(Environment env) {
        this.env = env;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();

        String allowedOrigins = env.getProperty("cors.allowed.origin");
        String allowedMethods = env.getProperty("cors.allowed.methods");
        String allowedHeaders = env.getProperty("cors.allowed.headers");
        String maxAge = env.getProperty("cors.set.max-age");
        Long maxAgeLong = null;
        if (maxAge != null && !maxAge.isEmpty()) {
            try {
                maxAgeLong = Long.parseLong(maxAge);
            } catch (NumberFormatException ignore) {
                // will catch on next stage with the rest
            }
        }

        if (allowedOrigins == null || allowedMethods == null || allowedHeaders == null || maxAgeLong == null) {
            throw new IllegalArgumentException("CORS config not defined properly");
        }

        List<String> allowedOriginsList = Arrays.asList(allowedOrigins.split(","));
        configuration.setAllowedOrigins(allowedOriginsList);

        List<String> allowedMethodsList = Arrays.asList(allowedMethods.split(","));
        configuration.setAllowedMethods(allowedMethodsList);

        List<String> allowedHeadersList = Arrays.asList(allowedHeaders.split(","));
        configuration.setAllowedHeaders(allowedHeadersList);

        configuration.setMaxAge(maxAgeLong);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
