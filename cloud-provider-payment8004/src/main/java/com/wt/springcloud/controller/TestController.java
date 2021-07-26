package com.wt.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.wt.springcloud.bean.PaymentBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName TestController
 * @Description
 * @Author wangtao
 * @Date 2020/10/31 13:25
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    @ResponseBody
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(@RequestBody PaymentBean paymentBean){
        log.info(paymentBean.toString());
        paymentBean.setRemark("备注");
//        return paymentBean;
        log.info("调用端口：" + port);
        return JSON.toJSONString(paymentBean);
//        return "呵呵";
    }

    @RequestMapping(value = "/payment/zk")
    @ResponseBody
    public String paymentzk(){
        return "springcloud with zookeeper: "+port+"\t"+ UUID.randomUUID().toString();
    }

}
