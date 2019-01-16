package com.hz.learnspring.task.test.base;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试基类
 *
 * @Author hezhao
 * @Time 2018-08-02 14:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class TestBase {

    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Test
    @Ignore
    public void test() {

    }
}
