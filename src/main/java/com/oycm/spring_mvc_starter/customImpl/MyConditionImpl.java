package com.oycm.spring_mvc_starter.customImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditionImpl implements Condition {

    private static final Logger log = LoggerFactory.getLogger(MyConditionImpl.class);

    private final static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.create();
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        log.info("AnnotatedTypeMetadata class: " + annotatedTypeMetadata.getClass().getName());

        return true;
    }
}
