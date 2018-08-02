package com.hz.learnspring.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.hz.learnspring.mybatis.dao.UserInfoMapper;
import com.hz.learnspring.mybatis.domain.UserInfo;
import com.hz.learnspring.mybatis.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoServiceTests extends TestBase {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testFindByUserName() {
        UserInfo user = userInfoMapper.findByUserName("admin");
        System.out.println("==================================testFindByUserName==================================");
        System.out.println(user);
        System.out.println("==================================testFindByUserName==================================");
    }

    @Test
    public void testFindAll() {
        List<UserInfo> users = userInfoMapper.findAll();
        System.out.println("==================================testFindAll==================================");
        users.forEach(System.out::println);
        System.out.println("==================================testFindAll==================================");
    }

    @Test
    public void testFindAllByPage() {
        List<UserInfo> pageInfo = getListByPage(2, 1);
        System.out.println("==================================testFindAllByPage==================================");
        pageInfo.forEach(e -> System.out.println(e));
        System.out.println("==================================testFindAllByPage==================================");
    }

    private List<UserInfo> getListByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> users = userInfoMapper.findAll();
        return users;
    }

}
