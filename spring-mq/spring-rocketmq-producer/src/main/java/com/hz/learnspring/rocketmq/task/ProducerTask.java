package com.hz.learnspring.rocketmq.task;

import com.alibaba.fastjson.JSON;
import com.hz.learnspring.rocketmq.domain.Message;
import com.hz.learnspring.rocketmq.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试定时任务，往队列里写数据
 *
 * Created by hezhao on 2018-07-25 09:17
 */
@Component
public class ProducerTask {

    @Autowired
    private Producer producer;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    // 用于计数
    private AtomicInteger count = new AtomicInteger(0);

    // 发生文本消息
    public void sendTextMessage() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者，我现在正在生产文本消息！现在的时间是：" + sdf.format(new Date());
        producer.sendMessage("test_string", "tagA", message);
    }

    // 发生JSON消息
    public void sendObjMessage() {
        int num = count.getAndIncrement();
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg("[" + num + "]" + UUID.randomUUID().toString());
        message.setSendTime(new Date());
        producer.sendMessage("test_message", "obj", JSON.toJSONString(message));
    }

}
