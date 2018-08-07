package com.hz.learnspring.rabbitmq.task;

import com.hz.learnspring.rabbitmq.domain.Person;
import com.hz.learnspring.rabbitmq.service.AmqpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试定时任务，往队列里写数据
 *
 * Created by hezhao on 2018-07-25 09:17
 */
@Component
public class AmqpSenderTask {

    @Autowired
    private AmqpSender sender;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String[] names = new String[]{"张三", "李四", "王二麻子", "赵一", "钱一", "孙一", "诸葛孔明", "刘备", "张飞", "曹操"};

    // 用于计数
    private AtomicInteger count = new AtomicInteger(0);

    // 工作队列模式
    public void sendSimpleMsg1() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者1，我现在正在生产 工作队列模式 消息！现在的时间是：" + sdf.format(new Date());
        sender.sendMessage("simple.message", message);
    }
    // 测试多个发送者
    public void sendSimpleMsg2() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者2，我现在正在生产 工作队列模式 消息！现在的时间是：" + sdf.format(new Date());
        sender.sendMessage("simple.message", message);
    }

    // 发布/订阅模式
    public void sendFanoutMsg() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者，我现在正在生产 发布/订阅模式 消息！现在的时间是：" + sdf.format(new Date());
        sender.sendMessage("fanoutExchange", "", message); // 不需要routingKey
    }

    // 主题模式， 发送对象
    public void sendTopicMsg1() {
        int num = count.getAndIncrement();
        int forMaxIndex = new Random().nextInt(50);
        Person person = Person.builder().name(names[forMaxIndex % 10] + "[" + num + "]").age(forMaxIndex).build();
        sender.sendMessage("topicExchange", "topic.message", person);
    }
    // 测试多个发送者
    public void sendTopicMsg2() {
        int num = count.getAndIncrement();
        int forMaxIndex = new Random().nextInt(50);
        Person person = Person.builder().name(names[forMaxIndex % 10] + "[" + num + "]").age(forMaxIndex).build();
        sender.sendMessage("topicExchange", "topic.messages", person);
    }

    // 路由模式
    public void sendDirectMsg() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者，我现在正在生产 路由模式 消息！现在的时间是：" + sdf.format(new Date());
        sender.sendMessage("directExchange", "demo", message);
    }

    // demo.test不匹配路由键会被丢弃
    public void sendDirectTestMsg() {
        int num = count.getAndIncrement();
        String message = "["+ num +"] " + Thread.currentThread().getName() + " - 我是生产者，我现在正在生产 路由模式-Test 消息！现在的时间是：" + sdf.format(new Date());
        sender.sendMessage("directExchange", "demo.test", message);
    }

}
