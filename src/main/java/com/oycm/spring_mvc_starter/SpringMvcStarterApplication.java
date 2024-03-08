package com.oycm.spring_mvc_starter;

import com.oycm.spring_mvc_starter.config.PropertiesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMvcStarterApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMvcStarterApplication.class, args);
        PropertiesConfig config = applicationContext.getBean("propertiesConfig", PropertiesConfig.class);
        System.out.println(config.propertiesDev);
    }
}
