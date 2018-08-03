package com.hz.learnspring.jpa.test;

import com.hz.learnspring.jpa.domain.UserInfo;
import com.hz.learnspring.jpa.service.UserInfoService;
import com.hz.learnspring.jpa.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoServiceTests extends TestBase {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testQueryUserList() {
        List<UserInfo> userList = userInfoService.queryUserList();
        logger.info("==================================testQueryUserList==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testQueryUserList==================================");
    }

    @Test
    public void testQueryUserByName() {
        List<UserInfo> userList = userInfoService.queryUserByName("b");
        logger.info("==================================testQueryUserByName==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testQueryUserByName==================================");
    }

    @Test
    public void testQueryUserById() {
        UserInfo user = userInfoService.queryUserById(1L);
        logger.info("==================================testQueryUserById==================================");
        logger.info("user:{}", user);
        logger.info("==================================testQueryUserById==================================");
    }

    @Test
    public void testSaveUser() {
        userInfoService.saveUser(UserInfo.builder().name("AA").userName("aa").password("123").build());
        userInfoService.saveUser(UserInfo.builder().name("BB").userName("bb").password("123").build());
        logger.info("==================================testSaveUser==================================");
        logger.info("insert count is " + 2);
    }

    @Test
    public void testUpdateNameByUserName() {
        int count = userInfoService.updateNameByUserName(UserInfo.builder().name("AA Updated").userName("aa").build());
        logger.info("==================================testUpdateNameByUserName==================================");
        logger.info("update count is " + count);
    }

    @Test
    public void testDeleteUser() {
        userInfoService.deleteUser(7L);
        logger.info("==================================testDeleteUser==================================");
        logger.info("delete count is " + 1);
    }

    @Test
    public void testSearchUserName() {
        List<UserInfo> userList = userInfoService.searchUserName("admin");
        logger.info("==================================testSearchUserName==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchUserName==================================");
    }

}
