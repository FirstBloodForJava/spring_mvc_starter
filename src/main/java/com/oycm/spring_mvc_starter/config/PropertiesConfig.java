package com.oycm.spring_mvc_starter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouyangcm
 * create 2024/3/8 9:10
 */
@Configuration
public class PropertiesConfig {

    @Value("${properties.dev}")
    public String propertiesDev;
}
