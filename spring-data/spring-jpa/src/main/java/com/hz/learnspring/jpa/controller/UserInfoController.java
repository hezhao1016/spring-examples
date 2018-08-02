package com.hz.learnspring.jpa.controller;

import com.hz.learnspring.jpa.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息控制器
 *
 * Created by hezhao on 2018-07-13 13:29
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 返回页面
     *
     * @param model
     * @return
     */
    @GetMapping(value = {"", "/list"})
    public String list(ModelMap model) {
        model.put("userList", userInfoService.queryUserList());
        return "index";
    }

    /**
     * restful风格，返回JSON
     *
     * @return
     */
    @GetMapping(value = "/api/list")
    @ResponseBody
    public Object list() {
        return userInfoService.queryUserList();
    }

}
