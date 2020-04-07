package com.example.mineappclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    @NotBlank
    @Size(max=5)
    String maker;

    @NotBlank
    @Size(max=50)
    String model;

    @NotNull

    int year;

    @NotBlank
    @Size(max=17, min=17)
    String vin_number;

    @NotNull
    int engine_power;

    @NotBlank
    String gearbox;

    @NotBlank
    String body_type;

    @NotBlank
    String colour;

    @NotBlank
    String fuel;

    @NotNull
    @Min(2)
    int number_of_seats;
}
