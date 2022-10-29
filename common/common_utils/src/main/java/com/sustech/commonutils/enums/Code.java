package com.sustech.commonutils.enums;

public enum Code {

    UNKNOWN_ERROR("未知错误",8000),
    RESOURCE_NOT_FOUND("未找到数据库中的资源",404),
    DUMPLICATE_REGISTERY("数据库中已有相同id",1000),
    INSERTION_FAILURE("数据库插入失败", 1001),
    MULTIPLE_LOGIN_ATTEMPT("尝试登录次数过多",2000),
    LOGIN_ERROR("登录信息错误",2001),

    N0_SERVICE_ERROR("没有对应的服务",3000);


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
