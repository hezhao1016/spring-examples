package com.hz.learnspring.redis.test;

import com.hz.learnspring.redis.test.base.TestBase;
import com.hz.learnspring.redis.test.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * Created by hezhao on 2018-07-05 11:09
 */
public class RedisTemplateTests extends TestBase {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() throws Exception {
        UserInfo user = new UserInfo(99L, "李逵", "likui", "123456");
        ValueOperations<String, UserInfo> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("com.likui", user);
        valueOperations.set("com.likui.f", user,1, TimeUnit.SECONDS);

        // Thread.sleep(1000);

        // redisTemplate.delete("com.likui.f");

        boolean exists = redisTemplate.hasKey("com.likui.f");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }

        System.out.println("==================================test1==================================");
        System.out.println(valueOperations.get("com.likui"));
        Assert.assertEquals("李逵", valueOperations.get("com.likui.f").getName());
        System.out.println("==================================test1==================================");
    }
}
