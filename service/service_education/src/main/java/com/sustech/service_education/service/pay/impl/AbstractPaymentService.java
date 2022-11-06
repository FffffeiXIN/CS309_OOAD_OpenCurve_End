package com.sustech.service_education.service.pay.impl;

import com.sustech.commonhandler.exception.DuplicateOrderException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Order;
import com.sustech.service_education.mapper.PayMapper;
import com.sustech.service_education.service.pay.PayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPaymentService implements PayService {

    @Autowired
    private PayMapper payMapper;
    @Override
    public Result purchase(String orderId) {
        doPurchase();
        return null;
    }

    @Override
    public Result createOrder(String courseId, int userId) {
        String orderId = courseId + "$" + userId;
        Order order = payMapper.getOrderById(orderId);
        if(order==null){
            order=new Order();
            order.setOrderId(orderId);
            order.setCreateTime(LocalDate.now().toString());
            order.setFinalUpdateTime(LocalDate.now().toString());
            order.setUserId(userId);
            order.setCourseId(courseId);
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
    public abstract void doPurchase();
}
