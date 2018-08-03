package com.hz.learnspring.redis.test;

import com.hz.learnspring.redis.test.base.TestBase;
import com.hz.learnspring.redis.util.RedisStrOperate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisStrTests extends TestBase {

    @Autowired
    private RedisStrOperate redisStrOperate;

    @Test
    public void testStr() {
        redisStrOperate.setStr("name", "horace");
        System.out.println("==================================testStr==================================");
        System.out.println(redisStrOperate.getStr("name"));
        System.out.println("==================================testStr==================================");
    }

}
