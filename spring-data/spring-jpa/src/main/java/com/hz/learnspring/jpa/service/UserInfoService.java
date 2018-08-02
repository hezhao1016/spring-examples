package com.hz.learnspring.jpa.service;

import com.hz.learnspring.jpa.domain.UserInfo;

import java.util.List;

/**
 * @Author hezhao
 * @Time 2018-08-03 21:35
 */
public interface UserInfoService {
    List<UserInfo> queryUserList();

    UserInfo queryUserById(Long id);

    UserInfo queryUserByUserName(String userName);

    List<UserInfo> queryUserByNameNativeQuery(String name);

    List<UserInfo> queryUserByName(String name);

    List<UserInfo> searchUserName(String userName);

    UserInfo saveUser(UserInfo userInfo);

    int updateNameByUserName(UserInfo userInfo);

    void deleteUser(Long id);

    int deleteUserByUserName(String userName);
}
