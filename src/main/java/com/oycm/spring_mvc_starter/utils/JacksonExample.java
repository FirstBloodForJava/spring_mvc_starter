package com.oycm.spring_mvc_starter.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.oycm.spring_mvc_starter.dto.Goods;

import java.io.IOException;

public class JacksonExample {

    public static void main(String[] args) throws IOException {
        String json = "{\n" +
                "    \"name\": \"name\",\n" +
                "    \"description\": \"description\",\n" +
                "    \"iName\": \"iName\",\n" +
                "    \"iDescription\": \"iDescription\"\n" +
                "}";
        JavaType javaType = JacksonUtil.getJavaType(Goods.class);

        Goods goods = JacksonUtil.stringToObject(json, javaType);
        Goods goods1 = JacksonUtil.stringToClass(json, Goods.class);

        System.out.println(JacksonUtil.objectToJson(goods, javaType));

        JacksonUtil.objectToPrintStream(goods1,System.out);



    }
}
