package com.edu.nulp.airport.controller;

import com.edu.nulp.airport.model.Country;
import com.edu.nulp.airport.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private final CountryServiceImpl countryService;

    @Autowired
    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country/{name}")
    public Country getCountryByName(@PathVariable("name") String name) {
        return countryService.findByName(name);
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }
}
