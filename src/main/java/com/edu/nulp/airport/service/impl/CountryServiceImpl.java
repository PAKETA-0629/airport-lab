package com.edu.nulp.airport.service.impl;

import com.edu.nulp.airport.exception.NotExistException;
import com.edu.nulp.airport.model.Country;
import com.edu.nulp.airport.repository.CountryRepository;
import com.edu.nulp.airport.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findByName(String name) {
        Optional<Country> optionalCountry = countryRepository.findByName(name);
        if (!optionalCountry.isPresent()) {
            log.debug("Country Not Exits");
            throw new NotExistException("Country not exist by name: " + name);
        }
        return optionalCountry.get();
    }
}
