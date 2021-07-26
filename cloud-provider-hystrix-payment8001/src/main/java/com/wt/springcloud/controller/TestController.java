package com.wt.springcloud.controller;

import com.wt.springcloud.serrvice.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author wangtao
 * @Date 2020/11/8 12:08
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/testok")
    public String testok(){
        return testService.testOk();
    }

    @RequestMapping("testtimeout")
    public String testtimeout(){
        return testService.testTimeOut();
    }

    @RequestMapping("/timeout1")
    public String timeout1(int i){
        return testService.testTimeOut1(i);
    }

}
