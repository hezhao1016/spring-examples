package com.hz.learnspring.mongodb.controller;

import com.hz.learnspring.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品 Controller
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public Object list() {
        return productRepository.findAll();
    }

    @GetMapping("/{name}")
    public Object get(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }

}
