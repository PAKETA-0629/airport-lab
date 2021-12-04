package com.edu.nulp.airport.service.impl;

import com.edu.nulp.airport.exception.NotExistException;
import com.edu.nulp.airport.model.City;
import com.edu.nulp.airport.repository.CityRepository;
import com.edu.nulp.airport.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCityById(Long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (!optionalCity.isPresent()) {
            log.debug("City not exist");
            throw new NotExistException("City not exist by id: " + id);
        }
        return optionalCity.get();
    }
}
