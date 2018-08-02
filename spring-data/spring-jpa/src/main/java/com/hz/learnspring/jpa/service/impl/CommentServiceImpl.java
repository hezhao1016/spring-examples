package com.hz.learnspring.jpa.service.impl;

import com.hz.learnspring.jpa.dao.CommentRepository;
import com.hz.learnspring.jpa.domain.Comment;
import com.hz.learnspring.jpa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author hezhao
 * @Time 2018-08-03 22:22
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> searchComment(String userName, String weiboText, Date startDate, Date endDate, Integer pageNo, Integer pageSize) {
        return commentRepository.searchComment(userName, weiboText, startDate, endDate, pageNo, pageSize);
    }
}
