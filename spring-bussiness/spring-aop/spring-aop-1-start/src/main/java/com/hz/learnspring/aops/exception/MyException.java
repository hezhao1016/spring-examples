package com.hz.learnspring.aops.exception;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常处理
 *
 * Created by hezhao on 2018-08-06 16:33
 */
public class MyException implements ThrowsAdvice {

	// 1.四个参数，Method method, Object[] args, Object target,Exception e
	public void afterThrowing(Method method, Object[] args, Object target,
							  RuntimeException e) {
		System.out.println("与顾客交谈失败，房子不能卖了");
	}

	// 2.一个参数，Exception e
//	public void afterThrowing(RuntimeException e) {
//
//	}

	// 异常类可写多个
	public void afterThrowing(ClassNotFoundException e) {

	}

}
