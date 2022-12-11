package com.sustech.commonutils.enums;

public enum Code {

    //规范：四位数错误码都为自定义错误
    /**
     * 1000+：数据库错误
     * 2000+：登录验证错误
     * 3000+：服务功能未提供
     * 4000+：支付错误
     */

    UNKNOWN_ERROR("未知错误",8000),
    RESOURCE_NOT_FOUND("未找到数据库中的资源",404),
    DUMPLICATE_REGISTERY("数据库中已有相同id,请勿重复注册",1000),
    DATABASE_OPERATION_FAILURE("数据库操作失败", 1001),
    MULTIPLE_LOGIN_ATTEMPT("尝试登录次数过多",2000),
    LOGIN_ERROR("登录信息错误",2001),
    N0_SERVICE_ERROR("没有对应的服务",3000),
    DUPLICATE_ORDER_ERROR("订单已存在",4000),
    INSUFFICIENT_PERMISSION_ERROR("权限不足",3001);


    private final String mess;
    private final Integer code;

    Code(String mess, Integer code){
        this.mess=mess;
        this.code=code;
    }

    public String getMess() {
        return mess;
    }

    public Integer getCode() {
        return code;
    }
}
