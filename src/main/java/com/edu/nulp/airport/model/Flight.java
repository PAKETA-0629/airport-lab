package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "plane", referencedColumnName = "id")
    private Plane plane;
    @Column(name = "flight_id")
    private String flightId;
    @Column(name = "departure_time")
    private Date departureTime;
    @Column(name = "arrival_time")
    private Date arrivalTime;
    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "id")
    @ToString.Exclude
    private Company company;
    @ManyToOne
    @JoinColumn(name = "departure_airport", referencedColumnName = "id")
    @ToString.Exclude
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "destination_airport", referencedColumnName = "id")
    @ToString.Exclude
    private Airport destinationAirport;

    @Column(name = "bc_price")
    private Long bcPrice;
    @Column(name = "ec_price")
    private Long ecPrice;
    @Column(name = "include_baggage")
    private Boolean includeBaggage;
    @Column(name = "include_meal")
    private Boolean includeMeal;
    @Column(name = "meal_price")
    private Long mealPrice;
    @Column(name = "departure_days")
    private String departureDays;
}
