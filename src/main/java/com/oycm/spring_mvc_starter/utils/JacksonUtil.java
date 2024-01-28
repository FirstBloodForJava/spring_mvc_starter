package com.oycm.spring_mvc_starter.utils;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

public class JacksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static JavaType getJavaType(Type type){
        return objectMapper.getTypeFactory().constructType(type);
    }

    /**
     * 字符串转Java对象
     * @param json json字符串
     * @param javaType 最终解析的Java对象类Type对应的JavaType
     * @return 泛型对象
     * @param <T>
     */
    public static <T> T stringToObject(String json, JavaType javaType){
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 输入流json转Java对象
     * @param inputStream json输入流
     * @param javaType 最终解析的Java对象类Type对应的JavaType
     * @return
     */
    public static Object inputStreamToObject(InputStream inputStream, JavaType javaType){
        try {
            return objectMapper.readValue(inputStream, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param json json字符串
     * @param clazz 结果类
     * @return json解析结果对象
     * @param <T>
     */
    public static <T> T stringToClass(String json, Class<T> clazz){
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转json字符串
     * @param object 要转成json的对象
     * @param javaType 对象的Type对应的JavaType
     * @return
     */
    public static String objectToJson(Object object, JavaType javaType){

        try {
            return objectMapper.writerFor(javaType).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 普通对象转输出流
     * @param object 对象
     * @param out 输出流
     * @throws IOException
     */
    public static void objectToPrintStream(Object object, OutputStream out) throws IOException {
        JsonGenerator generator = objectMapper.getFactory().createGenerator(out, JsonEncoding.UTF8);
        ObjectWriter writer = objectMapper.writer();
        writer.writeValue(generator, object);
        generator.flush();
    }
}
