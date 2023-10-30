package com.airreserve.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "flight")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "airPlaneMatricule")
    private AirPlane airPlane;

    @Column(name = "departureCity")
    private String departureCity;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departureDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime departureDate;

    @Column(name = "arrivalDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime arrivalDate;

    @Column(name = "ticketPrice")
    private String ticketPrice;

    @Column(name = "seatCount")
    private int seatCount;

    // Each flight can have multiple extras
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<FlightExtras> flightExtras;

    // Each flight can have multiple reservations
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
