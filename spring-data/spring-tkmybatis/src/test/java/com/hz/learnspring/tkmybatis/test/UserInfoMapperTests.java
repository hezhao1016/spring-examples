package com.hz.learnspring.tkmybatis.test;

import com.google.common.collect.Lists;
import com.hz.learnspring.tkmybatis.dao.UserInfoMapper;
import com.hz.learnspring.tkmybatis.domain.UserInfo;
import com.hz.learnspring.tkmybatis.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoMapperTests extends TestBase {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelectAll() {
        List<UserInfo> userList = userInfoMapper.selectAll();
        logger.info("==================================testSelectAll==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSelectAll==================================");
    }

    @Test
    public void testSelect() {
        UserInfo userInfo = UserInfo.builder().name("bob").build();
        List<UserInfo> userList = userInfoMapper.select(userInfo);
        logger.info("==================================testSelectUserList==================================");
        userList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSelectUserList==================================");
    }

    @Test
    public void testSelectOne() {
        UserInfo userInfo = UserInfo.builder().id(1L).build();
        UserInfo user = userInfoMapper.selectOne(userInfo);
        logger.info("==================================testSelectOne==================================");
        logger.info("user:{}", user);
        logger.info("==================================testSelectOne==================================");
    }

    @Test
    public void testInsertList() {
        List<UserInfo> list = Lists.newArrayList(
                UserInfo.builder().name("BB").userName("bb").password("123").build(),
                UserInfo.builder().name("AA").userName("aa").password("123").build()
        );

        int count = userInfoMapper.insertList(list);
        logger.info("==================================testInsertList==================================");
        logger.info("insert count is " + count);
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        int count = userInfoMapper.updateByPrimaryKeySelective(UserInfo.builder().id(10L).name("BB Updated").userName("bb").password("123").build());
        logger.info("==================================testUpdateByPrimaryKeySelective==================================");
        logger.info("update count is " + count);
    }

    @Test
    public void testDeleteByIds() {
        int count = userInfoMapper.deleteByIds(String.valueOf(7L));
        logger.info("==================================testDeleteByIds==================================");
        logger.info("delete count is " + count);
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
    public void testUpdateUser() {
        int count = userInfoMapper.updateUser(UserInfo.builder().name("BB Updated").userName("bb").build());
        logger.info("==================================testUpdateUser==================================");
        logger.info("update count is " + count);
    }

}
