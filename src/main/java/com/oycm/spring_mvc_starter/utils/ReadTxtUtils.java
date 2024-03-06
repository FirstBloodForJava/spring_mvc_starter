package com.oycm.spring_mvc_starter.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/3/5 14:12
 */
public class ReadTxtUtils {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\lenovo\\Desktop\\异常请求\\2294111.txt";
        String result = readTxtFile(filePath);

        Map<String,Object> map = JacksonUtil.stringToClass(result, Map.class);
        for (Map.Entry<String, Object> keyValue : map.entrySet()) {
            System.out.println(keyValue.getKey());
        }
        System.out.println(map.get("interfaceUrl"));
        System.out.println(map.get("exceptionMsg"));


    }

    public static String readTxtFile(String filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        FileInputStream inputStream = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String temp = null;
        while ( (temp = reader.readLine()) != null){
            builder.append(temp);
        }

        return builder.toString();
    }
}
