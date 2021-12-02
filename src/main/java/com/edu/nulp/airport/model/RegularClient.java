package com.edu.nulp.airport.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "regular_clients")
public class RegularClient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    private User user;
    @Column
    private Long points;
    @Column(name = "flight_distance")
    private Long flightDistance;
}
