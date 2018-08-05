package com.hz.learnspring.dubbo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口请求实体(必须序列化)
 *
 * @Author hezhao
 * @Time 2018-08-06 22:26
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 7615614884509926232L;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

}
