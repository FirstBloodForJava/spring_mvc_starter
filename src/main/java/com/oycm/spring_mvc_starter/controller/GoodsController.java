package com.oycm.spring_mvc_starter.controller;

import com.google.gson.Gson;
import com.oycm.spring_mvc_starter.dto.Goods;
import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GoodsController {
    protected final Log log = LogFactory.getLog(this.getClass());
    private Gson gson = new Gson();

    @PostMapping("/static/goods")
    public ReturnInfo userInfo(@RequestBody Goods goods){
        log.info(gson.toJson(goods));
        ReturnInfo info = new ReturnInfo();
        info.map = new HashMap<>();
        info.map.put("data", goods);
        return info;
    }
}
