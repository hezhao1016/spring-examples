package com.hz.learnspring.dubbo.test;

import com.alibaba.dubbo.rpc.RpcContext;
import com.hz.learnspring.dubbo.domain.Person;
import com.hz.learnspring.dubbo.service.DemoService;
import com.hz.learnspring.dubbo.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @Author hezhao
 * @Time 2018-08-06 1:21
 */
public class DemoServiceTests extends TestBase {

    @Autowired
    private DemoService demoService;

    @Test
    public void testSayHello() {
        // 隐式传参
        RpcContext.getContext().setAttachment("ThreadName", UUID.randomUUID().toString());

        Person person = Person.builder().name("艾编程").age(23).build();
        String sayHello = demoService.sayHello(person);
        System.out.println(sayHello);
    }

}
