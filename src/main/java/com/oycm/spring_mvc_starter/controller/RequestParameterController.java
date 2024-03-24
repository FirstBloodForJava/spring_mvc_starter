package com.oycm.spring_mvc_starter.controller;

import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParameterController {

    @PostMapping("/post/url")
    public ReturnInfo postUrlParameter(@RequestParam String name){
        ReturnInfo info = new ReturnInfo();

        info.setNote(name);

        return info;
    }

    @GetMapping("/get/url")
    public ReturnInfo getUrlParameter(@RequestParam String name){
        ReturnInfo info = new ReturnInfo();

        info.setNote(name);

        return info;
    }

}
