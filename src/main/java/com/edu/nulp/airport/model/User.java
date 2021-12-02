package com.edu.nulp.airport.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ToString.Exclude
    private Role role;
    @Column(name = "is_active")
    private Boolean isActive;
}
