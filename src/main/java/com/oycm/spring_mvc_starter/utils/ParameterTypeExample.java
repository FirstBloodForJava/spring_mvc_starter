package com.oycm.spring_mvc_starter.utils;

import com.oycm.spring_mvc_starter.dto.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class ParameterTypeExample {

    public static void main(String[] args) {
        Method[] declaredMethods = ParameterTypeExample.class.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter.getAnnotation(RequestBody.class) != null){
                    Type parameterizedType = parameter.getParameterizedType();
                    System.out.println(parameterizedType);
                    if (parameterizedType instanceof Class){
                        System.out.println("is Class");
                    }
                }
            }
        }

    }

    public void parameterType(@RequestBody User user){

    }
}
