package com.wt.springcloud.serrvice.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wt.springcloud.serrvice.TestService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @ClassName TestServiceImpl
 * @Description
 * @Author wangtao
 * @Date 2020/11/8 12:06
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String testOk() {
        return Thread.currentThread().getName() + "  请求成功";
    }

    // 服务降级
    @Override
    @HystrixCommand(fallbackMethod = "testTimeOutHandle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String testTimeOut() {
        int i = 1/0;
        int time = 5;
        try {
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "  请求超时" + time + "秒";
    }

    public String testTimeOutHandle(){
        return Thread.currentThread().getName() + "  系统繁忙，请稍后再试";
    }

    //服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "testTimeOutHandle",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "100000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "1"),// 失败率达到多少后跳闸
    })
    public String testTimeOut1(int i) {
        if(i > 0){
            return UUID.randomUUID().toString();
        }else{
            throw new RuntimeException();
        }
    }

    public String testTimeOutHandle(int i){
        return Thread.currentThread().getName() + "  系统繁忙，请稍后再试" + i;
    }
}
