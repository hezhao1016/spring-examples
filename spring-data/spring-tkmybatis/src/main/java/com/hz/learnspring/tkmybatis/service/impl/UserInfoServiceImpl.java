package com.hz.learnspring.tkmybatis.service.impl;

import com.hz.learnspring.tkmybatis.dao.UserInfoMapper;
import com.hz.learnspring.tkmybatis.domain.UserInfo;
import com.hz.learnspring.tkmybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryAll() {
        return userInfoMapper.selectAll();
    }

}
