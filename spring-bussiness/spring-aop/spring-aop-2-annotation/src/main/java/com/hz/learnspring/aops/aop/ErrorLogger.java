package com.hz.learnspring.aops.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP类，错误日志
 * Created by hezhao on 2018-08-06 16:33
 */
@Component
@Aspect
public class ErrorLogger {

	// 异常增强
	@AfterThrowing(pointcut="execution( * com.hz.learnspring.aops.service..sale(..))", throwing="ex")
	public void maiFangError(JoinPoint jp, RuntimeException ex) {
		System.out.println(jp.getSignature().getName() + " 方法发生异常：" + ex);
	}

}
