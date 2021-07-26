package com.wt.springcloud.controller;

import com.wt.springcloud.bean.PaymentBean;
import com.wt.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author wangtao
 * @Date 2020/11/7 15:45
 */
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        PaymentBean paymentBean = new PaymentBean();
        paymentBean.setId("11");
        paymentBean.setName("哈哈");
        return testService.test1(paymentBean);
    }
}
