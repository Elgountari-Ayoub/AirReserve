package com.airreserve.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "flightExtras")
@Data
public class FlightExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private java.math.BigDecimal price;
}