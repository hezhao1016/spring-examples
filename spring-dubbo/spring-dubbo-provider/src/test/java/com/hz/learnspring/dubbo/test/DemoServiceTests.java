package com.hz.learnspring.dubbo.test;

import com.hz.learnspring.dubbo.domain.Person;
import com.hz.learnspring.dubbo.service.DemoService;
import com.hz.learnspring.dubbo.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hezhao
 * @Time 2018-08-06 0:51
 */
public class DemoServiceTests extends TestBase {

    @Autowired
    private DemoService demoService;

    @Test
    public void testSayHello() {
        Person person = Person.builder().name("艾编程").age(23).build();
        String sayHello = demoService.sayHello(person);
        System.out.println(sayHello);
    }

}
