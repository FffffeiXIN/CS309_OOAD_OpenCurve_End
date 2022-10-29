package com.sustech.commonhandler;


import com.sustech.commonhandler.exception.RepeatRegisterException;
import com.sustech.commonhandler.exception.ServiceNotFoundException;
import com.sustech.commonhandler.exception.SourceNotFoundException;
import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result UnknownError(){
        return Result.error().code(Code.UNKNOWN_ERROR.getCode()).message(Code.UNKNOWN_ERROR.getMess());
    }

    @ExceptionHandler(RepeatRegisterException.class)
    public Result RepeatRegisterError(){
        return Result.error().code(Code.DUMPLICATE_REGISTERY.getCode()).message(Code.DUMPLICATE_REGISTERY.getMess());
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public Result ServiceNotFoundError(){
        return Result.error().code(Code.N0_SERVICE_ERROR.getCode()).message(Code.N0_SERVICE_ERROR.getMess());
    }

    @ExceptionHandler(SourceNotFoundException.class)
    public Result SourceNotFoundError(){
        return Result.error().code(Code.RESOURCE_NOT_FOUND.getCode()).message(Code.RESOURCE_NOT_FOUND.getMess());
    }
}
