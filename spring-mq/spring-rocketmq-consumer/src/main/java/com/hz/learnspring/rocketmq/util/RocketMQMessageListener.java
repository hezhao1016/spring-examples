package com.hz.learnspring.rocketmq.util;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消费者监听, 具体的实现请继承此类
 *
 * Created by hezhao on 2018-08-07 16:30
 */
public abstract class RocketMQMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQMessageListener.class);

    protected final DefaultMQPushConsumer consumer;

    /**
     * 初始化消息消费者
     *
     * @param servers       RocketMQ地址
     * @param consumerGroup 消费者组名
     * @param topic         主题
     * @param tag           标记, *代表全部的Tag
     */
    public RocketMQMessageListener(String servers, String consumerGroup, String topic, String tag) {
        // 初始化一个consumer, consumerGroup名字作为构造方法的参数
        consumer = new DefaultMQPushConsumer(consumerGroup);

        // 设置NameServer地址，多个地址之间用;分隔
        consumer.setNamesrvAddr(servers);

        // 设置consumer的消费策略
        // CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
        // CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
        // CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        // 开始监听消息
        getMessage(topic, tag);
    }

    // 具体监听实现
    protected abstract MessageListenerConcurrently messageListenerConcurrently();

   /**
     * 接收消息
     * @param topic 主题
     * @param tag 标记, *代表全部的Tag
     */
    public void getMessage(String topic, String tag){
        try {
            // 设置consumer所订阅的Topic和Tag，*代表全部的Tag
            consumer.subscribe(topic, tag);

            // 设置一个Listener，主要进行消息的逻辑处理
            consumer.registerMessageListener(messageListenerConcurrently());

            //调用start()方法启动consumer
            consumer.start();

            System.out.println("Consumer Started.");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

}
