package com.jian.exceptioninfo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "NOT FOUNC")
public class NotFindException  extends RuntimeException{
}
