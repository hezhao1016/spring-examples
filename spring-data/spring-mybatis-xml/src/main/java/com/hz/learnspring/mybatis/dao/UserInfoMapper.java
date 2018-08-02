package com.hz.learnspring.mybatis.dao;

import com.hz.learnspring.mybatis.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * @Author hezhao
 * @Time 2018-08-02 18:17
 */
public interface UserInfoMapper {
    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    UserInfo findByUserName(@Param("userName") String userName);

    /**
     * 查询所有
     * @return
     */
    List<UserInfo> findAll();
}
