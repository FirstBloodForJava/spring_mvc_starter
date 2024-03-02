package com.oycm.spring_mvc_starter;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class SpringMvcStarterApplicationTests {

    public static void main(String[] args) throws IOException {
        Map<String, List<String>>  result = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        result = loadSpringFactories(classLoader, "META-INF/spring.factories");

        InputStream in = classLoader.getResourceAsStream("META-INF/spring.factories");
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties);

    }

    public static Map<String, List<String>> loadSpringFactories(ClassLoader classLoader, String filePath) {
        MultiValueMap<String, String> result = null;
        try {
            Enumeration<URL> urls = (classLoader != null ? classLoader.getResources(filePath) : ClassLoader.getSystemResources(filePath));
            result = new LinkedMultiValueMap<>();

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                System.out.println(url);
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                for (Map.Entry<?, ?> entry : properties.entrySet()) {
                    String factoryClassName = ((String) entry.getKey()).trim();
                    for (String factoryName : StringUtils.commaDelimitedListToStringArray((String) entry.getValue())){
                        result.add(factoryClassName, factoryName.trim());
                    }
                }
            }
            return result;
        } catch (IOException ex) {
            throw new IllegalArgumentException("Unable to load factories from location [" + filePath+ "]", ex);
        }
    }
}
