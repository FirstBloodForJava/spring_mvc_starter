package com.oycm.spring_mvc_starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyangcm
 * create 2023/12/26 13:53
 */
@RestController
public class ExampleController {

    @RequestMapping("/static/index")
    public String staticIndex() {
        return "staticIndex!";
    }
}
