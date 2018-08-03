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
    public void testFindByUserName() {
        UserInfo user = userInfoMapper.findByUserName("admin");
        logger.info("==================================testFindByUserName==================================");
        logger.info("user:{}", user);
        logger.info("==================================testFindByUserName==================================");
    }

    @Test
    public void testFindAll() {
        List<UserInfo> users = userInfoMapper.findAll();
        logger.info("==================================testFindAll==================================");
        users.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testFindAll==================================");
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
        List<UserInfo> users = userInfoMapper.findAll();
        return users;
    }

}
