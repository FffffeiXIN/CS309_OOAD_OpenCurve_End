package com.sustech.service_education.controller;


import com.alipay.api.AlipayApiException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/education/pay")
@CrossOrigin
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/purchase")
    public void pay(String courseId,String userId, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        Result result = payService.createOrder(courseId,userId);
        String orderId = (String) result.getData().get("id");
        String res_frame = payService.purchase(orderId, request, response);
//        return res_frame;
//        Map<String,Object> data=new HashMap<>();
//        data.put("order",orderId);
//        data.put("frame", res_frame);
//        return Result.ok().code(200).message("支付成功!").data(data);
    }
}
