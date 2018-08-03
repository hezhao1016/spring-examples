package com.hz.learnspring.jdbc.test;

import com.hz.learnspring.jdbc.domain.UserInfo;
import com.hz.learnspring.jdbc.service.UserInfoService;
import com.hz.learnspring.jdbc.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoServiceTests extends TestBase {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testQueryAll() {
        List<UserInfo> userList = userInfoService.queryAll();
        logger.info("==================================testQueryAll==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testQueryAll==================================");
    }

    @Test
    public void testQueryByUserName() {
        UserInfo user = userInfoService.queryByUserName("admin");
        logger.info("==================================testQueryByUserName==================================");
        logger.info("user:{}", user);
        logger.info("==================================testQueryByUserName==================================");
    }

    @Test
    public void testInsert() {
        userInfoService.insert(UserInfo.builder().name("CC").userName("cc").password("123").build());
        userInfoService.insert(UserInfo.builder().name("DD").userName("dd").password("123").build());
        logger.info("==================================testInsert==================================");
        logger.info("insert count is " + 2);
    }

    @Test
    public void testUpdateByUserName() {
        int count = userInfoService.updateByUserName(UserInfo.builder().name("AA Updated2").userName("aa").password("123").build());
        logger.info("==================================testUpdateByUserName==================================");
        logger.info("update count is " + count);
    }

    @Test
    public void testDeleteByUserName() {
        userInfoService.deleteByUserName("admin");
        logger.info("==================================testDeleteByUserName==================================");
        logger.info("delete count is " + 1);
    }

}
