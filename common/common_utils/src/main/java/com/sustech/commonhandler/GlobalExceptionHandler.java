package com.sustech.commonhandler;


import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Result UnknownError(){
        return Result.error().code(Code.UnknownError.getCode()).message(Code.UnknownError.getMess());
    }

}
