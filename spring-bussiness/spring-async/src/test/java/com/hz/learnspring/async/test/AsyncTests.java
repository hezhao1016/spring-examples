package com.hz.learnspring.async.test;

import com.hz.learnspring.async.service.AsyncTaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AsyncTests {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext.xml");
        AsyncTaskService asyncTaskService = applicationContext.getBean(AsyncTaskService.class);

        // 观察日志，可以看到我们两个任务是异步交替进行的。
        for (int i = 0; i < 100; i++) {
            asyncTaskService.f1(); // 执行异步任务
            asyncTaskService.f2();
        }
    }

}
