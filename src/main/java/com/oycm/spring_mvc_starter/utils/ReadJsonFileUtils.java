package com.oycm.spring_mvc_starter.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/2/21 14:40
 */
public class ReadJsonFileUtils {

    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.create();
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        String str = "[1024,2014,4111]";

        //List<Integer> gsonList = gsonToList(str, new TypeToken<List<Integer>>(){}.getType());
        //List<Integer> integers = jacksonJsonToList(str, Integer.class);
        List<Integer> integers = fastjsonToList(str, Integer.class);



    }

    public static <T> List<T> fastjsonToList(String json, Class<T> clazz){
        return JSON.parseArray(json, clazz);
    }

    public static Map<String,Object> fastjsonToMap(String jsonStr){
        return JSON.parseObject(jsonStr, Map.class);
    }

    /**
     * 使用gson解析json字符串
     * @param jsonStr
     * @return
     */
    public static Map<String,Object> gsonToMap(String jsonStr){
        return gson.fromJson(jsonStr, Map.class);
    }

    public static <T> T gsonToList(String jsonStr, Type typeOfT){
        return gson.fromJson(jsonStr, typeOfT);
    }

    /**
     * 使用Jackson解析json字符串
     * @param json
     * @return
     * @throws IOException
     */
    public static Map<String,Object> jacksonJsonToMap(String json) throws IOException {

        return objectMapper.readValue(json, Map.class);
    }

    public static <T> List<T> jacksonJsonToList(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructType(List.class, clazz));
    }



    public static Map<String,Object> readFileJson(String filePath) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        StringBuilder jsonBuilder = new StringBuilder();
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null){
            jsonBuilder.append(temp);
        }

        String str = jsonBuilder.toString();
        return gsonToMap(jsonBuilder.toString());

    }
}
