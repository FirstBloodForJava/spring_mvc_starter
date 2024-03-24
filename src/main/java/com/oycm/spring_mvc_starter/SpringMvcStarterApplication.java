package com.oycm.spring_mvc_starter;

import com.oycm.spring_mvc_starter.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// (scanBasePackages = {"org"})
@SpringBootApplication
@RestController
public class SpringMvcStarterApplication {

    @Autowired
    private MessageSource messageSource;
    @RequestMapping("/")
    public String home() {
        String message = messageSource.getMessage("hello.message", new Object[]{"123"}, null);
        System.out.println(message);
        return "Hello World!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMvcStarterApplication.class, args);
        PropertiesConfig config = applicationContext.getBean("propertiesConfig", PropertiesConfig.class);
        System.out.println(config.propertiesDev);
    }
}
