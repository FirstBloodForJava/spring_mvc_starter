package com.oycm.spring_mvc_starter.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/2/20 10:12
 */
public class HttpUtils {

    private static final Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.create();
    }


    public static String httpPost(String url, Map<String,Object> body, Map<String,String> header) throws IOException {

        URL apiUrl = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        connection.setRequestMethod("POST");

        // 设置请求头
        for (Map.Entry<String, String> keySet : header.entrySet()) {
            connection.setRequestProperty(keySet.getKey(), keySet.getValue());
        }

        // 设置连接时间
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // 输出流
        connection.setDoOutput(true);

        DataOutputStream outPut = new DataOutputStream(connection.getOutputStream());

        outPut.writeBytes(gson.toJson(body));

        System.out.println(connection.getResponseCode());

        BufferedReader inReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String tempLine = null;
        while ((tempLine = inReader.readLine()) != null){
            response.append(tempLine);
        }
        inReader.close();
        return response.toString();
    }
}
