package com.hz.learnspring.task.task;

import com.hz.learnspring.task.util.LoggerUtil;
import org.springframework.stereotype.Component;

/**
 * XML方式配置的定时任务
 *
 * @Author hezhao
 * @Time 2018-08-07 0:28
 */
@Component("xmlTask")
public class XMLTask {

    /**
     * 要运行的方法1
     */
    public void runCron() {
        LoggerUtil.error("XMLTask:::runCron() 在运行");
    }

    /**
     * 要运行的方法2
     */
    public void runRate() {
        LoggerUtil.error("XMLTask:::runRate() 在运行");
    }

}
