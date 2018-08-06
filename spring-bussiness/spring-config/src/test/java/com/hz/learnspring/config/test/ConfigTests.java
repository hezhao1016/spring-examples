package com.hz.learnspring.config.test;

import com.hz.learnspring.config.BookProperties;
import com.hz.learnspring.config.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hezhao
 * @Time 2018-08-06 0:51
 */
public class ConfigTests extends TestBase {

    @Autowired
    private BookProperties bookProperties;

    @Test
    public void test1() {
        System.out.println(bookProperties);
    }

}
