package com.hz.learnspring.aops.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * AOP类，中介看房
 * Created by hezhao on 2018-08-06 16:33
 */
public class ZhongJieKanFang implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {

	// 前置增强
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("中介收取10元看房费");

	}

	// 后置增强
	public void afterReturning(Object returnObject, Method method, Object[] args,
							   Object target) throws Throwable {
		Double money = (Double) args[0];
		System.out.println("中介收取 2% 过户费：" + (money * 0.02) + "万");
	}

	// 环绕增强
	public Object invoke(MethodInvocation invocation) throws Throwable {
		double money = (Double) invocation.getArguments()[0];
		money*=1.02;
		invocation.getArguments()[0] = money;
		Object result = invocation.proceed();
		return result;
	}
	
}
