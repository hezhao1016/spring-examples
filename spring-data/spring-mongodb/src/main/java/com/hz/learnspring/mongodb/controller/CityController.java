package com.hz.learnspring.mongodb.controller;

import com.hz.learnspring.mongodb.domain.City;
import com.hz.learnspring.mongodb.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 城市 Controller
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public String list(ModelMap model) {
        List<City> cityList = cityRepository.findAllCity();
        model.put("cityList",cityList);
        return "index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Object get(@PathVariable("id") Long id) {
        return cityRepository.findById(id);
    }

}
