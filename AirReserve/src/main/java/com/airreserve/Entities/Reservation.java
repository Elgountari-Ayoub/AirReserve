package com.airreserve.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    @Id
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_code")
    @Id
    private Client client;

    @Column(name = "status")
    private String status = "CONFIRMED";
}