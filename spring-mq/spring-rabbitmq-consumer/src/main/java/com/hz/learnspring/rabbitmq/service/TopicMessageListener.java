package com.hz.learnspring.rabbitmq.service;

import com.alibaba.fastjson.JSON;
import com.hz.learnspring.rabbitmq.domain.Person;
import com.hz.learnspring.rabbitmq.util.AmqpListenerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Topic消息监听 继承AmqpListenerTemplate
 *
 * Created by hezhao on 2018-08-07 16:08
 */
public class TopicMessageListener extends AmqpListenerTemplate<Person> {
    private static final Logger logger = LoggerFactory.getLogger(TopicMessageListener.class);

    @Override
    public boolean verify(Person messageBean) {
        return true;
    }

    @Override
    public Person parseMessage2Bean(Map<String, Object> messageHeader, String messageBody) {
        return JSON.parseObject(messageBody, Person.class);
    }

    @Override
    public void execute(Person messageBean) {
        logger.info("TopicMessageListener person receive data ::: " + messageBean.toString());
        // 处理业务...
    }

}
