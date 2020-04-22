package com.jian.service.impl;

import com.jian.service.EhcacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EhcacheServiceImpl implements EhcacheService {

    @Cacheable(value = "user",key = "#name")
    public String find(String name) {
        String str = name + System.currentTimeMillis();
        return str;
    }

    @Override
    @CacheEvict("user")
    public void remove(String js) {
        return;
    }


}
