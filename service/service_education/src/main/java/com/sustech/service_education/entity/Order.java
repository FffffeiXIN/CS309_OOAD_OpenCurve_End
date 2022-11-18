package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Order {

    String OrderId;

    String createTime;

    String finalUpdateTime;

    String CourseId;

    String userId;

    String payType;

    String status;

}
