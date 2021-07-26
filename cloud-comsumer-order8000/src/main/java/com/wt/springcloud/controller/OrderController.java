package com.wt.springcloud.controller;

//import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description
 * @Author wangtao
 * @Date 2020/10/31 14:06
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    
//    private static final String url = "http://localhost:8001/test/test1";
    private static final String url = "http://CLOUD-PAYMENT-SERVICE/test/test1";

    @RequestMapping("/consumer/order1")
    @ResponseBody
    public String order1(){
//        JSONObject json = new JSONObject();
        Map json = new HashMap();
        json.put("id","1");
        json.put("name","哈哈");
        String s = restTemplate.postForObject(url, json, String.class);
        log.info("返回===》"+s);
        return s;
    }
}
