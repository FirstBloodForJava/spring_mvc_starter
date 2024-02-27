package com.oycm.spring_mvc_starter.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouyangcm
 * create 2024/2/27 9:44
 */
@Configuration
@ConditionalOnClass( name = "com.oycm.spring_mvc_starter.utils.HttpUtils")
public class ConditionalOnClassConfig {

    private static final Logger log = LoggerFactory.getLogger(ConditionalOnClassConfig.class);

    public ConditionalOnClassConfig() {
        log.info("ConditionalOnClassConfig被加载");
    }
}
