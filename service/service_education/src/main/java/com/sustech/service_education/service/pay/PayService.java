package com.sustech.service_education.service.pay;

import com.sustech.commonutils.Result;

public interface PayService {

    Result purchase(String orderId);

    Result createOrder(String courseId, int userId);
}
