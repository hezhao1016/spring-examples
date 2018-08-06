package com.hz.learnspring.quartz.test;

import com.hz.learnspring.quartz.test.base.TestBase;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author hezhao
 * @Time 2018-08-07 1:00
 */
public class ApplicationTests extends TestBase {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Test
    public void testApp() throws InterruptedException {
        logger.info("开始运行...");

        // countDownLatch 可以让非Web项目一直运行下去
        countDownLatch.await();
    }

}
