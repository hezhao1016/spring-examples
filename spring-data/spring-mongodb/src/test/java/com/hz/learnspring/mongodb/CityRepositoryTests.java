package com.hz.learnspring.mongodb;

import com.hz.learnspring.mongodb.base.TestBase;
import com.hz.learnspring.mongodb.repository.CityRepository;
import com.hz.learnspring.mongodb.domain.City;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hezhao on 2018-08-03 11:09
 */
public class CityRepositoryTests extends TestBase {
    @Autowired
    private CityRepository cityRepository;

    @Test
    public void testSaveCity() {
        // 保存对象, 根据Id是否存在来决定是否是新增还是更新
        City city1 = City.builder()
                .id(440300L)
                .provinceId(440000L)
                .cityName("深圳市")
                .description("深圳，简称“深”，别称“鹏城”，是中国四大一线城市之一，广东省省辖市、计划单列市、副省级市、国家区域中心城市、超大城市，" +
                        "国务院定位的全国经济中心城市和国际化城市、国家创新型城市、国际科技产业创新中心、全球海洋中心城市、国际性综合交通枢纽，中国三大全国性金融中心之一。")
                .build();
        City city2 = City.builder()
                .id(441300L)
                .provinceId(440000L)
                .cityName("惠州市")
                .description("惠州，背靠罗浮山，南临大亚湾，境内东江蜿蜒100多公里，属珠江三角洲、粤港澳大湾区东岸。" +
                        "惠州毗邻深圳、香港，北连河源市，东接汕尾市，西邻东莞市和广州市，是珠江三角洲中心城市之一 [1]  。" +
                        "惠州辖惠城区、惠阳区、惠东县、博罗县、龙门县2区3县，并设有两个国家级开发区：大亚湾经济技术开发区、仲恺高新技术产业开发区。")
                .build();
        cityRepository.saveCity(city1);
        cityRepository.saveCity(city2);
    }

    @Test
    public void testFindAllCity() {
        List<City> cityList = cityRepository.findAllCity();

        logger.info("==================================testFindAllCity==================================");
        cityList.forEach(e -> logger.info(e.toString()));
        logger.info("==================================testFindAllCity==================================");
    }

    @Test
    public void testFindById() {
        City city = cityRepository.findById(440300L);

        logger.info("==================================testFindById==================================");
        logger.info(city.toString());
        logger.info("==================================testFindById==================================");
    }

    @Test
    public void testFindByCityName() {
        City city = cityRepository.findByCityName("深圳市");

        logger.info("==================================testFindByCityName==================================");
        logger.info(city.toString());
        logger.info("==================================testFindByCityName==================================");
    }

    @Test
    public void testSaveCity2() {
        // 更新
        City city = cityRepository.findById(441300L);
        if(city != null){
            city.setDescription("惠州，深圳人的后花园。");
            cityRepository.saveCity(city);
        } else {
            logger.info("城市信息不存在。");
        }

    }

    @Test
    public void testUpdateCityByCityName() {
        City city = City.builder().cityName("深圳市").provinceId(440000L).description("来了就是深圳人！一句多么温馨的话。").build();
        cityRepository.updateCityByCityName(city);
    }

    @Test
    public void testDeleteCity() {
        cityRepository.deleteCity(441300L);
    }

}
