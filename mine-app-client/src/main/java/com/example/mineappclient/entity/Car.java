package com.example.mineappclient.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @NotNull
    @Column(name="maker")
    String maker;

    @NotNull
    @Column(name="model")
    String model;

    @NotNull
    @Column(name="year")
    int year;

    @NotNull
    @Column(name="vin_number", unique = true)
    String vin_number;

    @NotNull
    @Column(name="engine_power")
    int engine_power;

    @NotNull
    @Column(name="gearbox")
    String gearbox;

    @NotNull
    @Column(name="body_type")
    String body_type;

    @NotNull
    @Column(name="colour")
    String colour;

    @NotNull
    @Column(name="fuel")
    String fuel;

    @NotNull
    @Column(name="number_of_seats")
    int number_of_seats;

}
