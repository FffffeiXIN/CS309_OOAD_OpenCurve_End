package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayMapper {
    void updateOrder(Order order);
    Order getOrderById(String orderId);
    void addOrder(Order order);
    void deleteOrder(String orderId);
}
