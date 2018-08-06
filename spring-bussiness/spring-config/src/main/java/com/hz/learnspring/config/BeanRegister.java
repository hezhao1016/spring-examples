package com.hz.learnspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过@Bean注解注入对象
 *
 * @Author hezhao
 * @Time 2018-08-06 23:48
 */
@Configuration
public class BeanRegister {

    @Bean
    public Runnable createRunnable(){
        return () -> System.out.println("spring is running...");
    }

    @Bean
    public Map createMap(){
        Map map = new HashMap();
        map.put("username","zhangsan");
        map.put("age",27);
        return map;
    }

}
