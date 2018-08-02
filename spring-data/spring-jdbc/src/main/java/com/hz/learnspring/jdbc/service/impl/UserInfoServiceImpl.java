package com.hz.learnspring.jdbc.service.impl;

import com.hz.learnspring.jdbc.dao.UserInfoDao;
import com.hz.learnspring.jdbc.domain.UserInfo;
import com.hz.learnspring.jdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserInfoService 实现
 *
 * @Author hezhao
 * @Time 2018-08-02 14:17
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> queryAll() {
        return userInfoDao.queryAll();
    }

    @Override
    public UserInfo queryByUserName(String userName) {
        return userInfoDao.queryByUserName(userName);
    }

    @Override
    public int insert(UserInfo userInfo) {
        return userInfoDao.insert(userInfo);
    }

    @Override
    @Transactional
    public int updateByUserName(UserInfo userInfo) {
        int count = userInfoDao.updateByUserName(userInfo);
        if(userInfo.getName().length() > 5){
            // name 字段长度必须小于等于 5，否则回滚事务
            throw new RuntimeException("userInfo name is too long. ");
        }
        return count;
    }

    @Override
    public int deleteByUserName(String userName) {
        return userInfoDao.deleteByUserName(userName);
    }
}
