package com.jian.exceptioninfo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public String handleDulicate() {
        return "error/error";
    }

}
