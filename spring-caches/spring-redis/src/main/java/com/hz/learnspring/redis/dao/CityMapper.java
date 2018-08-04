package com.hz.learnspring.redis.dao;

import com.hz.learnspring.redis.domain.City;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * @Author hezhao
 * @Time 2018-08-04 23:59
 */
public interface CityMapper {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
