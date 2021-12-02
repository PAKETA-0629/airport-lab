package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ordered_tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "flight", referencedColumnName = "id")
    private Flight flight;
    @Column
    private String seat;
    @Column(name = "departure_date")
    private Date departureDate;
    @ManyToOne
    @JoinColumn(name ="client", referencedColumnName = "id")
    @ToString.Exclude
    private Client client;
    @Column(name = "baby_seat")
    private Boolean babySeat;
    @Column(name = "payment_date")
    private Date paymentDate;
}
