package com.example.mineappclient.controller;

import com.example.mineappclient.dto.ApiResponse;
import com.example.mineappclient.dto.CarDto;
import com.example.mineappclient.dto.CombinedResponseDto;
import com.example.mineappclient.entity.Car;
import com.example.mineappclient.exceptions.ResourceNotFoundException;
import com.example.mineappclient.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;
    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @GetMapping("")
    public CombinedResponseDto<Iterable<Car>> getCar(){
        return new CombinedResponseDto<Iterable<Car>>(carService.getCar(),instanceId);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveCar(@Valid @RequestBody CarDto carDto) throws SQLException {
        carService.saveCar(carDto);
        return new ResponseEntity<>(
                new ApiResponse(true, "Car saved successfully"),
                HttpStatus.ACCEPTED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @Valid @RequestBody CarDto carDto) {
        Car car = Car.builder()
                .maker(carDto.getMaker())
                .model(carDto.getModel())
                .body_type(carDto.getBody_type())
                .colour(carDto.getColour())
                .engine_power(carDto.getEngine_power())
                .fuel(carDto.getFuel())
                .gearbox(carDto.getGearbox())
                .number_of_seats(carDto.getNumber_of_seats())
                .vin_number(carDto.getVin_number())
                .year(carDto.getYear())
                .build();
        car.setId(id);
        carService.update(car);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) throws EmptyResultDataAccessException {
        carService.deleteById(id);

    }

}