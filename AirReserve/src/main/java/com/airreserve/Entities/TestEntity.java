package com.airreserve.Entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "TestEntity")
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pass")
    private String pass;


}