package com.airreserve.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "company")
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    // Each company is managed by one admin
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Each company can have multiple airplanes
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<AirPlane> airPlanes;
}
