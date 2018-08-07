package com.hz.learnspring.kafka.service;

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
public class StringMessageListener implements MessageListener<String, String> {

    private Logger logger = LoggerFactory.getLogger(StringMessageListener.class);

    @Override
    public void onMessage(ConsumerRecord<String, String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            String message = kafkaMessage.get().toString();
            String str = Thread.currentThread().getName() + " - 消费者1 - topic = " + record.topic() +
                    ", key = " + record.key() + ", offset = " + record.offset() + ", message = " + message;
            logger.info(str);
        }
    }

}
