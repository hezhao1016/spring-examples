package com.hz.learnspring.redis.service.impl;

import com.hz.learnspring.redis.dao.BookRepository;
import com.hz.learnspring.redis.domain.Book;
import com.hz.learnspring.redis.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/** Book 业务层实现
 * Created by hezhao on 2018-06-29 09:18
 */
@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        logger.info("新增书籍：" + book);
        return bookRepository.insertByBook(book);
    }

    @CachePut(value = "books", key = "#p0.id")
    @Override
    public Book update(Book book) {
        logger.info("更新书籍：" + book);
        return bookRepository.update(book);
    }

    @CacheEvict(value = "books", key = "#p0")
    @Override
    public Book delete(Long id) {
        logger.info("根据ID删除书籍：{}", id);

        return bookRepository.delete(id);
    }

    @Cacheable(value = "books", key = "#p0")
    @Override
    public Book findById(Long id) {
        logger.info("根据ID：{} 获取书籍信息", id);
        Book book = bookRepository.findById(id);
        return book;
    }
}
