package com.hz.learnspring.config.test;

import com.hz.learnspring.config.BookProperties;
import com.hz.learnspring.config.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by hezhao on 28/06/2018.
 */
public class SpringConfigApplicationTests extends TestBase {

    // 通过自动注入获取ApplicationContext
    @Autowired
    private ApplicationContext context;

    @Test
    public void test1() {
        // 获取Bean
        context.getBean(Runnable.class).run();

        BookProperties book = context.getBean(BookProperties.class);
        System.out.println(book);

        Map map = (Map) context.getBean("createMap");
        int age = (int) map.get("age");
        System.out.println("age=="+age);
    }
}
