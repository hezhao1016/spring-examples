package com.hz.learnspring.redis.test;

import com.hz.learnspring.redis.test.base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by hezhao on 2018-07-05 11:09
 */
public class StringRedisTemplateTests extends TestBase {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("nickName", "小乌龟");
        System.out.println("==================================test1==================================");
        System.out.println(valueOperations.get("nickName"));
        Assert.assertEquals("小乌龟", valueOperations.get("nickName"));
        System.out.println("==================================test1==================================");
    }
}
