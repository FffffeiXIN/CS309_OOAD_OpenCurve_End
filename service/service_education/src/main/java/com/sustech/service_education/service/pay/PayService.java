package com.sustech.service_education.service.pay;

import com.alipay.api.AlipayApiException;
import com.sustech.commonutils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PayService {

    String purchase(String orderId, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException;

    Result createOrder(String courseId, String userId);
    public void paySuccess(String orderId);
}
