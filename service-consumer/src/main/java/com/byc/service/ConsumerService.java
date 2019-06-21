package com.byc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by baiyc
 * 2019/6/19/019 20:27
 * Description：
 */
@FeignClient(value = "hello-service",fallback = FeignPatch.class)
public interface ConsumerService {
    @RequestMapping(value = "hello")
    String hello(@RequestParam(value = "id") String port);
}
