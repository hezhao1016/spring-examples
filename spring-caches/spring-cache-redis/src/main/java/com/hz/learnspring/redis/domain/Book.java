package com.hz.learnspring.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Book 实体类
 *
 * @Author hezhao
 * @Time 2018-07-05 9:50
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Book implements Serializable{
    private static final long serialVersionUID = 2266078595819790776L;

    /** 编号 */
    private Long id;

    /** 书名 */
    private String name;

    /** 作者 */
    private String author;

    /** 简介 */
    private String introduction;
}
