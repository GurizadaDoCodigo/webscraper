package com.gdcode.api.scrapper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@ConfigurationProperties(prefix = "com.gdcode.scrapper")
public class ScrapperProperties {
    private String agent;
    private String language = "*";
    private String currency = "$";
}
