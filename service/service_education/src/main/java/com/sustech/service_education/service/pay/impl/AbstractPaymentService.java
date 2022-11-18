package com.sustech.service_education.service.pay.impl;

import com.alipay.api.AlipayApiException;
import com.sustech.commonhandler.exception.DuplicateOrderException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Order;
import com.sustech.service_education.mapper.PayMapper;
import com.sustech.service_education.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPaymentService implements PayService {

    @Autowired
    private PayMapper payMapper;
    @Override
    public String purchase(String orderId, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {
        String res = doPurchase(orderId,request,response);
        return res;
    }

    @Override
    public Result createOrder(String courseId, String userId) {
        String orderId = courseId + "$" + userId;
        Order order = payMapper.getOrderById(orderId);
        if(order==null){
            order=new Order();
            order.setOrderId(orderId);
            order.setCreateTime(LocalDate.now().toString());
            order.setFinalUpdateTime(LocalDate.now().toString());
            order.setUserId(userId);
            order.setCourseId(courseId);
            order.setStatus("待支付");
            doCreateOrder(order);
            payMapper.addOrder(order);
            Map<String,Object> data = new HashMap<>();
            data.put("id",orderId);
            return Result.ok().message("订单创建成功").code(200).data(data);
        }else {
            throw new DuplicateOrderException();
        }
    }

    public abstract void doCreateOrder(Order order);
    public abstract String doPurchase(String orderId, HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException;
}
