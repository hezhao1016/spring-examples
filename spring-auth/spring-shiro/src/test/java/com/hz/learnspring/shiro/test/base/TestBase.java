package com.hz.learnspring.shiro.test.base;

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

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Ignore
    public void test() {

    }
}
