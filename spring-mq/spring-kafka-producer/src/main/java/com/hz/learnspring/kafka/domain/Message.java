package com.hz.learnspring.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 消息实体类
 *
 * @Author hezhao
 * @Time 2018-07-28 12:00
 */
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Message {

    // id
    private Long id;
    // 消息
    private String msg;
    // 时间戳
    private Date sendTime;

}
