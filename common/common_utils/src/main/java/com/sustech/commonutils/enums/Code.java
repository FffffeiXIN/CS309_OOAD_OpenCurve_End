package com.sustech.commonutils.enums;

public enum Code {

    UnknownError("未知错误",8000),
    RESOURCE_NOT_FOUND("未找到资源",404);

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
