package com.sustech.service_education.config;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000121693548";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQClEGIZpAK7He+leMZdDYN5ivsEjFjGsFdhExAHF7YBeHe8Y7ZJiQwLTQs0jEbBwukenjEQlZR9oOuSOxGO3vDl7h930cl3x9MiDNR7pg9v3SZQZ6xGMQ4WVJG6ZcD220NGIauevVbqTlFyAcBu96eCT1Ht+ZQtg9pYAMowCiB5nXX+KHlO6FDwfbpCjAyW0w3H8xMYq59l1c1sLIuqgZWrqS+6qsULKU2A6/9Hyu0nzWBJ7/yd788+RhfP0BP5xGpct/ba/RBk8hQh4MNTvPrXApFP6/SDTqpZxIwAC0Yjq53P/vsdabuL+JgqTGIZKLM/ci+hRy1Ig+ZiwJouOeyhAgMBAAECggEBAIvVEDYGgiXAG4dDhE/KJenuOe5FcuOG+c8L1hUcGhyu0Ehw9Djhd6mPMAHpH/v/QXulqY0SGoQ+sbHkhmBRLySqEFByEUl+p7b9xXemWwd6An41BXVFE1kJdZbBorG9WAVuerP0VFAT3t1E7J9U/7vdtFt0hfn07CCHMsF1osNCqFm26+sU8HYWJEEtckjrlibBgi9XeaeUbrj4rEePbXcnslyWEqoYZHlkFGHo0KUgt9V8zYbaAZvhQNqHpAE8KATtrGVGIt7uHNydM2ARddL2Wq1DxsuR4u4WUn9HpAOhrySYkrrxXBi1Yo4/6hg7/9/JGdkNlR8nkWMPh2hEu+0CgYEA7lpvkATz7yt3VQ0/BlJ2/VYpsR7UeZIG+8Y8BfmXX2/D5gRyYRcdhA0shvZF3cpsKOibg7Ozc4ODbvI2XZSElYiQX7HIoVEcH36IR8iAGhcoAAoDqF0PMeCBvhlr0yb6J554ZIFJSSJIf6D896Hyrf6QqFnf21ugPai9VaBKufsCgYEAsUjhCvVpdnkZ/ZxSbS3Tev/ROfLADkPFygUKULDWfYbvVBEexTe5/mgARkZiGekUHYsq5QIo8/Vvug+pAA2AKKJGHl7caJlCvqTlCBUV3nvENKOf5Qy5A+ESlrCv28WGCTg3uD2JG6WOKXqfNU8ZZQx1TyS7MtM8JHAQ5VZnLRMCgYAvTyP1ogYI4se8yfRIfPXBMujzjvr9Zk6ciqw/Q1sYRkbL0PYi70OcgkDkSN11OEhflkvHyFNGCkR8MPc5e9EVHRYK6G66Fi9O0P6bwOAsTYxS9ankMRRjAfy+jq0oLARa+MlMqZyyN2vMaVfMjwhsIKr1v2D/WSBlHKj35ejvIQKBgQCUeav4CJbd4QiSbSRfSdzvC2bIOHT+vWXeDqCX+bJ5iNPRvVDe7Q/5cFKiiHnKp3jwUUiIaWmw/6Il2s24PJZT8av17Y58j7blgaZLQZWCMnedelgEdcZR6GMwDyQJVIEwIYQQ6oB0xg+sz4SdGfTzux5YPTQGmgCpp62O1PEuPwKBgCVKXx5DKB6jxvnXG0R8nkiICj5scGj/mysWgU6WXwk2XsBiARDCAxnIUKQxG4YlVuSsKNuQGlfL47UB4CdRdwpSFYKI4Tt9nEe8rkdKabSQUFr0r9Ac5j8TyqsBRsb9GDweHHKBmX24KhigOlfwN+tRe7ET93SCp16MuKvfTxZn";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1dJGkvOybqaN09uCEa3c8e68r6rEdw3tuRL3ulyXP9GtfGfSUJMIT/h8Oj4FLlY0KWqIaAUeLaDFzf1AwLWNYUNkSa7PlhkUsa5hT4Lk7bs8uTYZeav/izqOVERdBT7ZDqtHZY9BtJMEbiqyn8dps9KLInhZH4cfUytZq58TfM9zYpVUL2vgVaQSatxlIuyeQsAI9+YT0E7mEpRLsCex1nsjxmS3E/RH9OfHkEQk/7hSm2zvjlPUFmyE1lUN5cRMm77ZQZxnkTbryQd4Z/usSCKZjFZk7DK5u0ZlGTRaIHfdUH3DiZSVWft9HOEJvGjetMei7cbFukY9qWdit8cExwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8080/callback/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8082/userPage/StudentCourseCenter";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 日志目录
    public static String log_path = "./";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

