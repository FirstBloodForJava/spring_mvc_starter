package com.oycm.spring_mvc_starter.source.core;

import org.springframework.util.ConcurrentReferenceHashMap;

/**
 * @author ouyangcm
 * create 2024/2/28 16:45
 */
public class SpringCoreConcurrentReferenceHashMap {

    public static void main(String[] args) {
        ConcurrentReferenceHashMap<String, String> referenceMap = new ConcurrentReferenceHashMap<>();

        System.out.println(referenceMap.put("key", "value"));

        System.out.println(referenceMap);

    }
}
