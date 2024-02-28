package com.oycm.spring_mvc_starter.config;

import com.oycm.spring_mvc_starter.customImpl.MyConditionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(MyConditionImpl.class)
public class ConditionalConfig {

    private static final Logger log = LoggerFactory.getLogger(ConditionalConfig.class);

    public ConditionalConfig() {
        log.info("ConditionalConfig 创建成功");
    }
}
