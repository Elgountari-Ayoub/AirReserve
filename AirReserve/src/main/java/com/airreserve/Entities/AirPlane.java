package com.airreserve.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "airPlane")
@Data
public class AirPlane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule")
    private int matricule;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "name")
    private String name;

    // Each airplane can be used for multiple flights
    @OneToMany(mappedBy = "airPlane", cascade = CascadeType.ALL)
    private List<Flight> flights;
}
