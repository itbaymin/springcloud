package com.byc.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by baiyc
 * 2019/6/19/019 20:53
 * Description：
 */
@Component
public class FeignPatch implements ConsumerService {
    public String hello(@RequestParam(value = "id") String port) {
        return "Sorry i am error";
    }
}
