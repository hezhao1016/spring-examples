package com.hz.learnspring.kafka.service;

import com.alibaba.fastjson.JSON;
import com.hz.learnspring.kafka.domain.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

import java.util.Optional;

/**
 * 消费者监听
 *
 * Created by hezhao on 2018-08-07 18:34
 */
public class KafkaMessageListener implements MessageListener<String, String> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        // 根据不同主题，消费
        switch (record.topic()) {
            case "test.string":
                stringMessage(record);
                break;
            case "test.message":
                jsonMessage(record);
                break;
            default:
                logger.info("topic:" + record.topic() + " 未找到匹配！");
        }
    }

    private void jsonMessage(ConsumerRecord<String, String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String message = kafkaMessage.get().toString();

            String str = Thread.currentThread().getName() + " - 消费者 KafkaMessageListener - topic = " + record.topic()
                    + ", key = " + record.key() + ", offset = " + record.offset() + ", message = " + message;
            logger.info(str);
        }
    }

    private void stringMessage(ConsumerRecord<String, String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String json = kafkaMessage.get().toString();
            // 转换为对象
            Message message = JSON.parseObject(json, Message.class);

            String str = Thread.currentThread().getName() + " - 消费者 KafkaMessageListener - topic = " + record.topic()
                    + ", key = " + record.key() + ", offset = " + record.offset() + ", message = " + message;
            logger.info(str);
        }
    }

}
