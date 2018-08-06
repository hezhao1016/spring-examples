package com.hz.learnspring.exception.controller;

import com.hz.learnspring.exception.exception.BadRequestException;
import com.hz.learnspring.exception.exception.MyException;
import com.hz.learnspring.exception.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class DemoController {

    // 用于测试
    @RequestMapping("/{view}")
    public Object index(@PathVariable("view") String view) throws Exception {
        View v = View.getView(view);
        switch (v) {
            case sql:
                throw new SQLException("数据库异常！");
            case bad:
                throw new BadRequestException("失败的请求！");
            case myexception:
                throw new MyException(50000, "这是一个自定义的异常！");
            case exception:
                return 1 / 0;
            default:
                throw new NotFoundException("页面未找到！");
        }
    }

    /**
     * 测试代码：有效页面枚举类
     */
    private enum View {
        sql, bad, myexception, exception, none;

        public static View getView(String view) {
            for (View v : View.values()) {
                if (v.toString().equalsIgnoreCase(view)) {
                    return v;
                }
            }
            return none;
        }
    }

}