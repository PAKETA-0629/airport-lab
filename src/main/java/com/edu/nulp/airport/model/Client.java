package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "personal_information")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "born")
    private Date born;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "passport_id")
    private String passportId;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ToString.Exclude
    private Account account;
}
