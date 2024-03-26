package com.oycm.spring_mvc_starter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages"); // 指定消息资源文件的基本名称（不含扩展名）
        source.setDefaultEncoding("UTF-8"); // 指定默认的编码方式
        return source;
    }
}
