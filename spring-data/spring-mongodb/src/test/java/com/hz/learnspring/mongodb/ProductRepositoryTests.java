package com.hz.learnspring.mongodb;

import com.hz.learnspring.mongodb.base.TestBase;
import com.hz.learnspring.mongodb.domain.Product;
import com.hz.learnspring.mongodb.repository.ProductRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Created by hezhao on 2018-08-03 11:09
 */
public class ProductRepositoryTests extends TestBase {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave() {
        Product product = Product.builder().id("1").name("华硕笔记本").build();
        // 插入
        productRepository.insert(product);
    }

    @Test
    public void testFindAll() {
        List<Product> productList = productRepository.findAll();

        logger.info("==================================testFindAll==================================");
        productList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testFindAll==================================");
    }

    @Test
    public void testFindById() {
        Optional<Product> productOptional = productRepository.findById("1");

        logger.info("==================================testFindById==================================");
        logger.info(productOptional.orElse(null).toString());
        logger.info("==================================testFindById==================================");
    }

}
