package com.hz.learnspring.redis.dao;

import com.hz.learnspring.redis.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Book 持久层操作接口
 *
 * Created by hezhao on 2018-07-05 09:16
 */
@Repository
public class BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);

    // 模拟数据库，存储 Book 信息
    private static Map<Long, Book> BOOK_DB = new HashMap<>();

    // 先初始化一些数据
    {
        Book book1 = Book.builder().id(1L).name("西游记").author("吴承恩").introduction("讲述师徒四人西天取经的故事。").build();
        Book book2 = Book.builder().id(2L).name("红楼梦").author("曹雪芹").introduction("古典爱情故事。").build();

        BOOK_DB.put(1L, book1);
        BOOK_DB.put(2L, book2);
    }

    public List<Book> findAll() {
        return new ArrayList<>(BOOK_DB.values());
    }

    public Book insertByBook(Book book) {
        book.setId(BOOK_DB.size() + 1L);

        logger.info("新增书籍：" + book);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    public Book update(Book book) {
        logger.info("更新书籍：" + book);
        BOOK_DB.put(book.getId(), book);
        return book;
    }

    public Book delete(Long id) {
        logger.info("删除书籍：" + id);
        return BOOK_DB.remove(id);
    }

    public Book findById(Long id) {
        Book book = BOOK_DB.get(id);
        logger.info("根据ID：{} 获取书籍信息：{}", id, book);
        return book;
    }

}
