package com.jian.controller;

import com.jian.service.EhcacheService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class EhCacheController {

    @Resource
    private EhcacheService ehcacheService;

    @RequestMapping(value = "ehcache",method = RequestMethod.GET)
    public String ehcache(Model model) {
        model.addAttribute("js",ehcacheService.find("js"));
        return "business/ehcache";
    }

    @RequestMapping(value = "remove",method = RequestMethod.GET)
    public String remove() {
        ehcacheService.remove("js");
        return "business/ehcache";
    }

}
