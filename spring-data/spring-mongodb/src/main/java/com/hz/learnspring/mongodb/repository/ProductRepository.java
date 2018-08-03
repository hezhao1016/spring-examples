package com.hz.learnspring.mongodb.repository;

import com.hz.learnspring.mongodb.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 商品 Repository 接口类
 *
 * @Author hezhao
 * @Time 2018-08-03 08:59
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    // 继承了 MongoRepository 会默认实现很多基本的增删改查，省了很多自己写dao层的代码

    // 不需要写实现
    Product findByName(String name);
}
