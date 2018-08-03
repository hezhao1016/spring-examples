package com.hz.learnspring.mongodb.repository;

import com.hz.learnspring.mongodb.domain.City;

import java.util.List;

/**
 * 城市 Repository 接口类
 *
 * @Author hezhao
 * @Time 2018-06-30 23:59
 */
public interface CityRepository {

    List<City> findAllCity();

    City findById(Long id);

    City findByCityName(String cityName);

    void saveCity(City city);

    void updateCityByCityName(City city);

    void deleteCity(Long id);
}
