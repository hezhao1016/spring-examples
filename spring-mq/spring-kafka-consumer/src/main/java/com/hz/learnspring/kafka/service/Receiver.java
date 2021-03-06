package com.hz.learnspring.kafka.service;

import com.alibaba.fastjson.JSON;
import com.hz.learnspring.kafka.domain.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息消费者 - 使用@KafkaListener注解
 *
 *  Created by hezhao on 2018-07-28 12:08
 */
@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    /**
     * 使用KafkaListener配置消费者监听的队列
     *
     * @param record 消息对象
     */
    @KafkaListener(topics = "test.string")
    public void listen1(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String message = kafkaMessage.get().toString();
            String str = Thread.currentThread().getName() + " - 消费者 Receiver - topic = " + record.topic() +
                    ", key = " + record.key() + ", offset = " + record.offset() + ", message = " + message;
            logger.info(str);
        }
    }

    /**
     * 接收JSON
     * @param record
     */
    @KafkaListener(topics = "test.message")
    public void listen2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String json = kafkaMessage.get().toString();
            // 转换为对象
            Message message = JSON.parseObject(json, Message.class);

            String str = Thread.currentThread().getName() + " - 消费者 Receiver - topic = " + record.topic()
                    + ", key = " + record.key() + ", offset = " + record.offset() + ", message = " + message;
            logger.info(str);
        }
    }

}
