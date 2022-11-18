package com.sustech.service_education.service.pay.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sustech.commonhandler.exception.DuplicateOrderException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.config.AlipayConfig;
import com.sustech.service_education.entity.Order;
import com.sustech.service_education.mapper.PayMapper;
import com.sustech.service_education.service.pay.PayService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    public String doPurchase(String orderId, HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException {
            //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = orderId;
            //付款金额，必填
            //要改 先去数据库里搜
            String total_amount = "1";
            //订单名称，必填
            String subject = "CS996";
            //商品描述，可空
            String body = "The course";

            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                    + "\"total_amount\":\"" + total_amount + "\","
                    + "\"subject\":\"" + subject + "\","
                    + "\"body\":\"" + body + "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");


            //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

            //构建支付宝官方支付页面
            String top = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                    "<title>付款</title>\n" +
                    "</head>";
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            String bottom = "<body>\n" +
                    "</body>\n" +
                    "</html>";
            //输出
//            response.getWriter().println(top + result + bottom);
            String res = top + result + bottom;
            return res;

    }
}
