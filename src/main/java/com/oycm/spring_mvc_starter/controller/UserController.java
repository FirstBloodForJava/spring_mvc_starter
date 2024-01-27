package com.oycm.spring_mvc_starter.controller;

import com.google.gson.Gson;
import com.oycm.spring_mvc_starter.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    protected final Log log = LogFactory.getLog(this.getClass());

    private Gson gson = new Gson();

    @PostMapping("/static/user")
    public User userInfo(@RequestBody(required = false) User user){
        log.info(gson.toJson(user));
        user.setAge(19);
        return user;
    }

    @PostMapping("/static/requiredUser")
    public User requiredUserInfo(@RequestBody User user){
        log.info(gson.toJson(user));
        user.setAge(19);
        return user;
    }
}
