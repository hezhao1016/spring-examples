package com.hz.learnspring.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 通过扩展QuartzJobBean来创建Quartz任务，需要实现它的executeInternal()方法
 * @author hezhao
 */
public class LoggerManager extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		// 打印当前的执行时间 例如 2017-11-23 00:00:00
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("现在的时间是："+ sf.format(date));

		// 具体的业务逻辑
		System.out.println("Hello Quartz...");

		JobDetail jobDetail = jobContext.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		JobKey jobKey = jobDetail.getKey();

		System.out.println("jobDetail 的name ： " + jobKey.getName());
		System.out.println("jobDetail 的group ： " + jobKey.getGroup());

		String message = jobDataMap.getString("message");
		System.out.println("jobDataMap定义的message的值 : " + message );

		TriggerKey triggerKey = jobContext.getTrigger().getKey();
		System.out.println("jobDetail 的name ： " + triggerKey.getName());
		System.out.println("jobDetail 的group ： " + triggerKey.getGroup());

		try {
			String schedulerName = jobContext.getScheduler().getSchedulerName();
			System.out.println("schedulerName : " + schedulerName);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

		System.out.println();
	}

}
