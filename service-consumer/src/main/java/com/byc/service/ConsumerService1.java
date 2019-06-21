package com.byc.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by baiyc
 * 2019/6/19/019 20:40
 * Description：
 */
@Service
public class ConsumerService1 {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String port){
        return restTemplate.getForObject("http://HELLO-SERVICE/hello?id="+port,String.class);
    }

    public String hiError(String port){
        return "Sorry there is error";
    }
}
