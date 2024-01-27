package com.oycm.spring_mvc_starter.utils;

import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class ParameterizedTypeExample {

    public static void main(String[] args) {
        // 获取所有的公共方法,包括继承的
        Method[] methods = ParameterizedTypeExample.class.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("parameterizedType")){
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    if (parameter.getAnnotation(RequestBody.class) != null){
                        Class<?> type = parameter.getType();
                        System.out.println("parameter type: " + type.getName());

                        // 参数泛型类型判断
                        if (parameter.getParameterizedType() instanceof ParameterizedType){
                            ParameterizedType parameterizedType = (ParameterizedType) parameter.getParameterizedType();
                            System.out.println("is ParameterizedType");
                            System.out.println("getActualTypeArguments: " + parameterizedType.getActualTypeArguments()[0].getTypeName());
                            System.out.println("getRawType: " + parameterizedType.getRawType());
                            System.out.println("getOwnerType: " + parameterizedType.getOwnerType());
                        }
                        if (parameter.getParameterizedType() instanceof TypeVariable){
                            System.out.println("is TypeVariable");
                        }
                    }
                }
            }
        }
    }

    public void parameterizedType(@RequestBody List<String> list){

    }
}
