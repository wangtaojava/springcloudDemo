package springcloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springcloud.bean.PaymentBean;

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

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        return "test2---8002";
//        return "呵呵";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(){
        return "test3---8002";
//        return "呵呵";
    }

}
