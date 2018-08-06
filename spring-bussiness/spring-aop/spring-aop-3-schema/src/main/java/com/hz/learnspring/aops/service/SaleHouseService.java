package com.hz.learnspring.aops.service;

import org.springframework.stereotype.Service;

/**
 * 具体业务：卖房
 * Created by hezhao on 2018-08-06 16:33
 */
@Service
public class SaleHouseService {

	public void watch(){
		System.out.println("看看房子怎么样...");
	}

	public void sale(double money){
		if(money > 100){
			throw new RuntimeException("太贵了，买不起");
		}
		System.out.println("房产公司正在卖房，金额 " + money + "万");
	}

}
