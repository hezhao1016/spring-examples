package com.hz.learnspring.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页
 *
 * Created by hezhao on 2018-08-03 14:30
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
