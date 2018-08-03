package com.hz.learnspring.jpa.test;

import com.hz.learnspring.jpa.service.CommentService;
import com.hz.learnspring.jpa.test.base.TestBase;
import lombok.val;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hezhao
 * @Time 2018-07-01 22:26
 */
public class CommentServiceTests extends TestBase {

    @Autowired
    private CommentService commentService;

    @Test
    public void testSearchComment(){
        val list = commentService.searchComment(null,"特金会", null, null, null, null);
        logger.info("==================================testSearchComment==================================");
        list.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testSearchComment==================================");
    }

}
