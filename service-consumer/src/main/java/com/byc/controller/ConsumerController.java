package com.byc.controller;

import com.byc.service.ConsumerService;
import com.byc.service.ConsumerService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by baiyc
 * 2019/6/19/019 20:16
 * Description：
 */
@RestController
public class ConsumerController {

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConsumerService consumerService;

    @Autowired
    ConsumerService1 consumerService1;

    @RequestMapping("hello")
    public String index(){
        return restTemplate.getForObject("http://HELLO-SERVICE/hello?id="+port,String.class);
    }

    @RequestMapping("feign")
    public String hello(){
        return consumerService.hello(port);
    }

    @RequestMapping("hys")
    public String hystrix(){
        return consumerService1.hiService(port);
    }

}
