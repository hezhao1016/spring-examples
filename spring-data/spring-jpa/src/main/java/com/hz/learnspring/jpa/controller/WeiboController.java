package com.hz.learnspring.jpa.controller;

import com.hz.learnspring.jpa.service.WeiboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微博控制器
 *
 * Created by hezhao on 2018-08-03 13:29
 */
@RestController
@RequestMapping("/weibo")
public class WeiboController {

    @Autowired
    private WeiboService weiboService;

    /**
     * restful风格，返回JSON
     *
     * @return
     */
    @GetMapping(value = "/get/{userName}")
    public Object get(@PathVariable("userName") String userName) {
        return weiboService.getUserWeibo(userName);
    }

}
