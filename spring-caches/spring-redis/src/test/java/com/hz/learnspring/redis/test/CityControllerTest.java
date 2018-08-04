package com.hz.learnspring.redis.test;

import com.hz.learnspring.redis.controller.CityController;
import com.hz.learnspring.redis.domain.City;
import com.hz.learnspring.redis.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hezhao on 2018-08-05 16:11
 */
public class CityControllerTest extends TestBase {

    @Autowired
    private CityController cityController;

    @Test
    public void findAllCity() {
        List<City> city = cityController.findAllCity();
        System.out.println(city);
    }

}