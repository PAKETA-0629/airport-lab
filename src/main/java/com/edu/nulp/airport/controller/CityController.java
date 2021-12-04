package com.edu.nulp.airport.controller;

import com.edu.nulp.airport.model.City;
import com.edu.nulp.airport.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private final CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable("id") Long id) {
        return cityService.getCityById(id);
    }
}
