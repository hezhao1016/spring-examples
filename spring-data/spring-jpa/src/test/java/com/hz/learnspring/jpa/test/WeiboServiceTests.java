package com.hz.learnspring.jpa.test;

import com.hz.learnspring.jpa.service.WeiboService;
import com.hz.learnspring.jpa.test.base.TestBase;
import lombok.val;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hezhao
 * @Time 2018-07-01 22:26
 */
public class WeiboServiceTests extends TestBase {

    @Autowired
    private WeiboService weiboService;

    @Test
    public void testGetUserWeibo(){
        val list = weiboService.getUserWeibo("admin");
        logger.info("==================================testGetUserWeibo==================================");
        list.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testGetUserWeibo==================================");
    }

    @Test
    public void testSearchWeibo(){
        val list = weiboService.searchWeibo("admin", "特金会", 1, 10);
        logger.info("==================================testSearchWeibo==================================");
        list.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchWeibo==================================");
    }

    @Test
    public void testSearchWeiboByCriteria(){
        val list = weiboService.searchWeiboByCriteria("admin", "特金会",null, null, 1, 10);
        logger.info("==================================testSearchWeiboByCriteria==================================");
        list.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchWeiboByCriteria==================================");
    }

    @Test
    public void testSearchWeiboByExampleMatcher(){
        val list = weiboService.searchWeiboByExampleMatcher("admin", "特金会");
        logger.info("==================================testSearchWeiboByExampleMatcher==================================");
        list.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchWeiboByExampleMatcher==================================");
    }

}
