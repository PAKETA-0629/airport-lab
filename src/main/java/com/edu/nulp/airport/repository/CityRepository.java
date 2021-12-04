package com.edu.nulp.airport.repository;

import com.edu.nulp.airport.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    Optional<City> findById(Long id);
}
