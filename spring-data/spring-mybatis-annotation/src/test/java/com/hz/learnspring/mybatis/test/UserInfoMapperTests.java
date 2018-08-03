package com.hz.learnspring.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.hz.learnspring.mybatis.dao.UserInfoMapper;
import com.hz.learnspring.mybatis.domain.UserInfo;
import com.hz.learnspring.mybatis.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoMapperTests extends TestBase {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testQueryAll() {
        List<UserInfo> userList = userInfoMapper.queryAll();
        logger.info("==================================testQueryAll==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testQueryAll==================================");
    }

    @Test
    public void testFindAllByPage() {
        List<UserInfo> pageInfo = getListByPage(2, 1);
        logger.info("==================================testFindAllByPage==================================");
        pageInfo.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testFindAllByPage==================================");
    }

    private List<UserInfo> getListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> users = userInfoMapper.queryAll();
        return users;
    }

    @Test
    public void testQueryUserList() {
        UserInfo userInfo = UserInfo.builder().name("b").build();
        List<UserInfo> userList = userInfoMapper.queryUserList(userInfo);
        logger.info("==================================testQueryUserList==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testQueryUserList==================================");
    }

    @Test
    public void testGetOne() {
        UserInfo user = userInfoMapper.getOne(1L);
        logger.info("==================================testGetOne==================================");
        logger.info("user:{}", user);
        logger.info("==================================testGetOne==================================");
    }

    @Test
    public void testInsertUser() {
        int count = userInfoMapper.insertUser(UserInfo.builder().name("AA").userName("aa").password("123").build());
        count += userInfoMapper.insertUser(UserInfo.builder().name("BB").userName("bb").password("123").build());
        logger.info("==================================testInsertUser==================================");
        logger.info("insert count is " + count);
    }

    @Test
    public void testUpdateUser() {
        int count = userInfoMapper.updateUser(UserInfo.builder().name("AA Updated").userName("aa").build());
        logger.info("==================================testUpdateUser==================================");
        logger.info("update count is " + count);
    }

    @Test
    public void testDeleteUser() {
        int count = userInfoMapper.deleteUser(7L);
        logger.info("==================================testDeleteUser==================================");
        logger.info("delete count is " + count);
    }

    @Test
    public void testSearchUser() {
        UserInfo userInfo = UserInfo.builder().id(1L).name("ja").userName("admin").build();
        List<UserInfo> userList = userInfoMapper.searchUser(userInfo);
        logger.info("==================================testSearchUser==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchUser==================================");
    }

    @Test
    public void testFindUser() {
        UserInfo userInfo = UserInfo.builder().id(1L).name("ja").userName("admin").build();
        List<UserInfo> userList = userInfoMapper.findUser(userInfo);
        logger.info("==================================testFindUser==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testFindUser==================================");
    }

}
