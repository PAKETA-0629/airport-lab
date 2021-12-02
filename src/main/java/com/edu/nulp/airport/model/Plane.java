package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_name", referencedColumnName = "id")
    @ToString.Exclude
    private Company company;
    @Column(name = "bc_capacity")
    private Long bcCapacity;
    @Column(name = "ec_capacity")
    private Long ecCapacity;
    @Column(name = "board_number")
    private String boardNumber;
}

