package com.flightnetwork.ticketbooking.discountService.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig {

    @Value("${dev.port}")
    private Integer devPort;

    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addBuilderCustomizers((UndertowBuilderCustomizer) builder -> builder.addHttpListener(devPort, "0.0.0.0"));
        return factory;
    }

}