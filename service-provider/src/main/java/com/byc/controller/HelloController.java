package com.byc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * Created by baiyc
 * 2019/6/19/019 17:59
 * Description：
 */
@RefreshScope
@RestController
public class HelloController {

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @Value("${test}")
    private String config;

    @RequestMapping("/hello")
    public String index(String id){
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        return "Hello "+id+" I am "+instances.get(0).getServiceId();
    }

    @RequestMapping("config")
    public String config(){
        return config;
    }

    public static void main(String[] args) {
        //String a,b;
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("请输入一个字符串：");
        //a = scanner.next();
        //System.out.println("请再输入一个字符串：");
        //b = scanner.next();
        //
        //System.out.println(dealStr(a,b));
        System.out.println(dealStr("ddaaaaaakkkbbbbewqeqw","afaaaaavcbbbbdadadadas"));
    }

    public static Set<String> dealStr(String a,String b){
        String tem = "";
        Set<String> res = new HashSet<String>();
        for (int i=0;i<a.length();i++){
            for (int j=0;j<b.length();j++){
                for (int x=i,y=j;x<a.length()&&y<b.length();x++,y++){
                    if(a.charAt(x)!=b.charAt(y))
                        break;
                    tem += a.charAt(x);
                }
                if(!"".equals(tem)){
                    res.add(tem);
                    tem = "";
                }
            }
        }
        int size = 0;
        for (String t:res){
            size = size>t.length()?size:t.length();
        }
        Iterator<String> iterator = res.iterator();
        while (iterator.hasNext()){
            if(iterator.next().length()!=size)
                iterator.remove();
        }
        return res;
    }

    public static String getMaxSubString(String s1, String s2) {
        StringBuffer re = new StringBuffer();
        String max, min;
        String label = "";
        boolean flag = true;
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = max.equals(s1) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            for (int a = 0, b = min.length() - i; b != min.length() + 1; a++, b++) {
                String sub = min.substring(a, b);
                if (max.contains(sub)) {
                    label = flag ? sub : label;
                    flag = false;
                    if(sub.length() >= label.length()) {
                        re.append(sub + ",");
                    } else {
                        continue;
                    }
                }
            }
        }
        return re.toString().substring(0, re.toString().length() - 1);
    }
}
