package com.edu.nulp.airport.model;

import lombok.Data;
import com.edu.nulp.airport.model.City;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "airports")
public class Airports {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "iata")
    private String iata;
    @Column(name = "ukll")
    private String ukll;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id")
    @ToString.Include
    private City city;

    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;


}
