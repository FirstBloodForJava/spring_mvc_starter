package com.oycm.spring_mvc_starter.controller;

import com.google.gson.Gson;
import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyangcm
 * create 2023/12/26 13:53
 */
@RestController
public class ExampleController {

    protected final Log log = LogFactory.getLog(this.getClass());

    private Gson gson = new Gson();

    @RequestMapping("/static/index")
    public ReturnInfo staticIndex() {

        ReturnInfo info = new ReturnInfo();
        info.setStatus(1);

        String result = null;
        System.out.println(result.toString());

        info.setNote("/static/index");
        return info;
    }

    @GetMapping("/statics/index.*")
    public String staticSuffix() {
        return "statics/index.*";
    }

    @GetMapping("/example")
    public String example() {
        return "example";
    }
}
