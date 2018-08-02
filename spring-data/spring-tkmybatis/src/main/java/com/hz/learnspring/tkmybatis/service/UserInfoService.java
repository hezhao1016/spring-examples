package com.hz.learnspring.tkmybatis.service;

import com.hz.learnspring.tkmybatis.domain.UserInfo;

import java.util.List;

/**
 * UserInfoService
 *
 * @Author hezhao
 * @Time 2018-08-02 14:17
 */
public interface UserInfoService {
    List<UserInfo> queryAll();

}
