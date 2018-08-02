package com.hz.learnspring.mybatis.service;

import com.hz.learnspring.mybatis.domain.UserInfo;

import java.util.List;

/**
 * UserInfoService
 *
 * @Author hezhao
 * @Time 2018-08-02 14:17
 */
public interface UserInfoService {
    List<UserInfo> findAll();

    UserInfo findByUserName(String userName);

}
