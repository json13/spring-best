package com.jian.controller;

import com.jian.exceptioninfo.DuplicateException;
import com.jian.exceptioninfo.NotFindException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String home() {
        if (true) {
            throw new DuplicateException();
        }
        return "home";
    }


}
