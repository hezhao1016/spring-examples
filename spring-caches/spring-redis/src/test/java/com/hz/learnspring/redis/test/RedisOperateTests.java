package com.hz.learnspring.redis.test;

import com.hz.learnspring.redis.test.base.TestBase;
import com.hz.learnspring.redis.util.RedisOperate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hezhao on 2018-07-05 12:17
 */
public class RedisOperateTests extends TestBase {

    @Autowired
    private RedisOperate redisOperate;

    @Test
    public void testStr() {
        System.out.println("==================================testStr==================================");

        redisOperate.setRedisStr("test1", "Test1", 60);
        System.out.println(redisOperate.getRedisStr("test1"));

        redisOperate.delRedisStr("test1");
        System.out.println(redisOperate.getRedisStr("test1"));

        System.out.println("==================================testStr==================================");
    }

    @Test
    public void testHash() {
        System.out.println("==================================testHash==================================");

        String key = "stu";

        redisOperate.insertRedisHash(key, "name", "jack", 60);
        redisOperate.insertRedisHash(key, "sex", "man", 60);

        System.out.println(redisOperate.queryRedisHash(key, "name"));
        System.out.println(redisOperate.queryRedisHash(key, "sex"));

        redisOperate.deleteRedisHash(key, "name");
        System.out.println(redisOperate.queryRedisHash(key, "name"));
        System.out.println(redisOperate.queryRedisHash(key, "sex"));

        System.out.println("==================================testHash==================================");
    }

    @Test
    public void testMap() {
        System.out.println("==================================testMap==================================");

        String key = "emp";

        redisOperate.insertRedisHash(key, "name", "bob", 60);
        redisOperate.insertRedisHash(key, "sex", "man", 60);

        System.out.println(redisOperate.queryRedisMap(key, "name"));
        System.out.println(redisOperate.queryRedisMap(key, "sex"));

        System.out.println("==================================testMap==================================");
    }

}
