package com.edu.nulp.airport.service;

import com.edu.nulp.airport.model.Country;

import java.util.List;

public interface CountryService {

    Country findByName(String name);

    List<Country> findAll();
}
