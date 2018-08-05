package com.hz.learnspring.shiro.service;

import com.hz.learnspring.shiro.domain.UserInfo;

/**
 * 用户信息服务类
 */
public interface UserInfoService {
    /**
     * 通过username查找用户信息
     *
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);
}