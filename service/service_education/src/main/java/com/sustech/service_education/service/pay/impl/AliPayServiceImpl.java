package com.sustech.service_education.service.pay.impl;

import com.sustech.commonhandler.exception.DuplicateOrderException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Order;
import com.sustech.service_education.mapper.PayMapper;
import com.sustech.service_education.service.pay.PayService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class AliPayServiceImpl extends AbstractPaymentService {

    @Override
    public void doCreateOrder(Order order) {
        order.setPayType("Ali");
    }

    @Override
    public void doPurchase() {

    }
}
