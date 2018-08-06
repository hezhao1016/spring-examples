package com.hz.learnspring.aops.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * AOP类，错误日志
 * Created by hezhao on 2018-08-06 16:33
 */
@Component
public class ErrorLogger {

	// 异常增强
	public void maiFangError(JoinPoint jp, RuntimeException ex) {
		System.out.println(jp.getSignature().getName() + " 方法发生异常：" + ex);
	}

}
