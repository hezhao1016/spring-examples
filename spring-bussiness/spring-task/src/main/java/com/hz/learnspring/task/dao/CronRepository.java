package com.hz.learnspring.task.dao;

import com.hz.learnspring.task.domain.Cron;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Cron表达式保存在数据库
 *
 * 注：这里简单模拟一下数据库
 *
 * Created by hezhao on 2018-07-11 20:40
 */
@Repository
public class CronRepository {

    private static Logger logger = LoggerFactory.getLogger(CronRepository.class);

    private static Map<String, Cron> CRON_DB = new HashMap<>();

    // 初始化cron数据
    @PostConstruct
    public void initialCron() {
        insert(Cron.builder().id(1L).key("default").cron("0/2 * * * * ?").build());
        logger.info("初始化Cron数据完成。");
    }

    public Cron findByKey(String key) {
        Cron cron = CRON_DB.get(key);
        logger.info("根据key：{} 获取Cron信息：{}", key, cron);
        return cron;
    }

    public void updateCronByKey(String key, String cronStr) {
        Cron cron = findByKey(key);
        if (cron != null) {
            logger.info("更新Cron：" + key);
            cron.setCron(cronStr);
        }
    }

    public void insert(Cron cron) {
        logger.info("新增Cron：" + cron);
        CRON_DB.put(cron.getKey(), cron);
    }
}

