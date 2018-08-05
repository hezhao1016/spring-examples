package com.hz.learnspring.shiro.service.impl;

import com.hz.learnspring.shiro.dao.UserInfoDao;
import com.hz.learnspring.shiro.domain.UserInfo;
import com.hz.learnspring.shiro.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息服务实现类
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        logger.info("UserInfoServiceImpl.findByUsername()-->" + username);
        return userInfoDao.findByUsername(username);
    }
}