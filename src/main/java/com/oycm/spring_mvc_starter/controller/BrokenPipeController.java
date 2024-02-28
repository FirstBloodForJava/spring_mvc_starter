package com.oycm.spring_mvc_starter.controller;

import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class BrokenPipeController {

    protected final Log log = LogFactory.getLog(this.getClass());

    @PostMapping("/broken/pipe/{id}")
    public ReturnInfo brokenPipe(@PathVariable("id") Integer id){
        long start = System.currentTimeMillis();
        log.info("开始: " + id);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ReturnInfo info = new ReturnInfo();

        info.map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < id; i++) {
            list.add(String.valueOf(i));
        }
        info.map.put("data", list);
        info.setStatus(1);

        log.info("结束: " + (System.currentTimeMillis() - start));
        return info;
    }
}
