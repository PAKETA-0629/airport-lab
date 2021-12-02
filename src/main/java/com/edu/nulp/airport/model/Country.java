package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;

@Entity
@Data
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "country_id")
    private String countryId;
}
