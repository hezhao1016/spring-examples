package com.hz.learnspring.dubbo.service;

import com.hz.learnspring.dubbo.domain.Person;

/**
 * Demo服务接口
 *
 * Created by hezhao on 2018-08-06 17:03
 */
public interface DemoService {

    String sayHello(Person person);

}
