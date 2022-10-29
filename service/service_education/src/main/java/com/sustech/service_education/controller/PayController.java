package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/education/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/purchase")
    public Result pay(String courseId,int userId){
        Result result = payService.createOrder(courseId,userId);
        String orderId = (String) result.getData().get("id");
        payService.purchase(orderId);
        Map<String,Object> data=new HashMap<>();
        data.put("order",orderId);
        return Result.ok().code(200).message("支付成功!").data(data);
    }
}
