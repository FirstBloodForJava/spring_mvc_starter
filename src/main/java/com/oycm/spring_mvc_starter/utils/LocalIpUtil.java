package com.oycm.spring_mvc_starter.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ouyangcm
 * create 2024/2/23 20:40
 */
public class LocalIpUtil {

    public static String getLocalIp(){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String serverIpAddress = localHost.getHostAddress();
            System.out.println("Server IP Address: " + serverIpAddress);
            return serverIpAddress;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "0.0.0.0";
        }
    }
}
