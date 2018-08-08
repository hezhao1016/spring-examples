package com.hz.learnspring.rocketmq.service;

import com.hz.learnspring.rocketmq.util.RocketMQMessageListener;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 消费者监听
 *
 * Created by hezhao on 2018-08-07 16:30
 */
public class StringMessageListener extends RocketMQMessageListener {

    private Logger logger = LoggerFactory.getLogger(StringMessageListener.class);

    /**
     * 初始化消息消费者
     * @param servers RocketMQ地址
     * @param consumerGroup 消费者组名
     * @param topic 主题
     * @param tag 标记, *代表全部的Tag
     */
    public StringMessageListener(String servers, String consumerGroup, String topic, String tag) {
       super(servers, consumerGroup, topic, tag);
    }

    /**
     * 监听消息
     * @return
     */
    @Override
    protected MessageListenerConcurrently messageListenerConcurrently() {
        return (msgs, context) -> {

            for (MessageExt msg : msgs) {
                try {
                    String message = new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET);
                    logger.info(Thread.currentThread().getName() + " Receive New Messages: " + message);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            // 返回消费状态
            // CONSUME_SUCCESS 消费成功
            // RECONSUME_LATER 消费失败，需要稍后重新消费
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        };
    }

}
