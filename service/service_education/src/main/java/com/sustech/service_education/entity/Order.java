package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Order {

    String OrderId;

    String createTime;

    String finalUpdateTime;

    String CourseId;

    Integer userId;

    String payType;

}
