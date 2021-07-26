package com.wt.springcloud.service;

import com.wt.springcloud.bean.PaymentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestService
 * @Description
 * @Author wangtao
 * @Date 2020/11/7 15:43
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface TestService {

    @RequestMapping("/test/test1")
    String test1(PaymentBean paymentBean);
}
