package com.hz.learnspring.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.hz.learnspring.rocketmq.domain.Message;
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
public class JSONMessageListener extends RocketMQMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(StringMessageListener.class);

    /**
     * 初始化消息消费者
     * @param servers RocketMQ地址
     * @param consumerGroup 消费者组名
     * @param topic 主题
     * @param tag 标记, *代表全部的Tag
     */
    public JSONMessageListener(String servers, String consumerGroup, String topic, String tag) {
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

                    // 转换为对象
                    Message obj = JSON.parseObject(message, Message.class);

                    System.out.println(Thread.currentThread().getName() + " Receive New Messages JSON : " + obj);
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
