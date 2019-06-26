package com.byc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baiyc
 * 2019/6/26/026 19:17
 * Description：
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${test}")
    private String value;

    @RequestMapping("test")
    public String test(){
        return value;
    }
}
