package com.wt.springcloud.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PaymentBean
 * @Description
 * @Author wangtao
 * @Date 2020/10/31 13:47
 */
@Data
public class PaymentBean implements Serializable {
    private String id;
    private String name;
    private String remark;
}
