package com.hz.learnspring.task.task;

import com.hz.learnspring.task.util.LoggerUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 固定频率定时任务
 *
 * 注意：类需要加上@Component注解，不然Spring发现不了
 */
@Component
public class AppSchedulingConfig {
    /**
     * 每10秒执行一次
     *
     * @author zhangyd
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void doJobByCron() {
        LoggerUtil.info("-----------------doJobByCron");
    }

    /**
     * 固定每5秒执行一次
     *
     * @author zhangyd
     */
    @Scheduled(fixedRate = 5 * 1000)
    public void doJobByFixedRate() {
        LoggerUtil.info("-----------------doJobByFixedRate");
    }

    /**
     * 上次任务结束后一秒后再次执行
     *
     * @author zhangyd
     */
    @Scheduled(fixedDelay = 1 * 1000)
    public void doJobByFixedDelay() {
        LoggerUtil.info("******************doJobByFixedDelay");
    }

    /**
     * 第一次延迟1秒后执行，之后按fixedRate的规则每2秒执行一次
     *
     * @author zhangyd
     */
    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void doInitialDelay() {
        LoggerUtil.info("+++++++++++++++++++doInitialDelay");
    }

}
