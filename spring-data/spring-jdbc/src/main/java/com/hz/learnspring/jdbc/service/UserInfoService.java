package com.hz.learnspring.jdbc.service;

import com.hz.learnspring.jdbc.domain.UserInfo;

import java.util.List;

/**
 * UserInfoService
 *
 * @Author hezhao
 * @Time 2018-08-02 14:17
 */
public interface UserInfoService {
    List<UserInfo> queryAll();

    UserInfo queryByUserName(String userName);

    int insert(UserInfo userInfo);

    int updateByUserName(UserInfo userInfo);

    int deleteByUserName(String userName);
}
