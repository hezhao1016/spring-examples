package com.hz.learnspring.aops.service;

/**
 * 具体业务：卖房
 * Created by hezhao on 2018-08-06 16:33
 */
public class SaleHouseService {

	public void sale(double money){
		if(money > 100){
			throw new RuntimeException("太贵了，买不起");
		}
		System.out.println("房产公司正在卖房，金额 " + money + "万");
	}

}
