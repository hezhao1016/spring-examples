package com.hz.learnspring.aops.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP类，中介看房
 * Created by hezhao on 2018-08-06 16:33
 */
@Component
@Aspect
public class ZhongJieKanFang {

	// 前置增强
	@Before(value="execution( * com.hz.learnspring.aops.service..watch(..))")
	public void kanFang(JoinPoint jp){
		System.out.println("中介收取10元看房费");
	}

	// 后置增强
	@AfterReturning(value="execution( * com.hz.learnspring.aops.service..sale(..))", returning="result")
	public void guoHu(JoinPoint jp, Object result){
		Double money = (Double) jp.getArgs()[0];
		System.out.println("中介收取 2% 过户费：" + (money * 0.02) + "万");
	}

	// 环绕增强
	@Around("execution( * com.hz.learnspring.aops.service..sale(..))")
	public Object maiFang(ProceedingJoinPoint jp) throws Throwable{
		Double money = (Double) jp.getArgs()[0];
		if(money > 30){
			System.out.println("太贵了，买不起了");
			return null;
		}
		money*=1.02;
		jp.getArgs()[0] = money;
		Object result = jp.proceed();
		return result;
	}

	// 最终增强
	@After("execution( * com.hz.learnspring.aops.service..sale(..))")
	public void afterLogger(JoinPoint jp) {
		System.out.println(jp.getSignature().getName() + " 方法结束执行。");
	}

}
