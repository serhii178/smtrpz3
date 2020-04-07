package smtrpz.mineappgateway.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smtrpz.mineappgateway.CarClient;
import smtrpz.mineappgateway.dto.ApiResponse;
import smtrpz.mineappgateway.dto.CarDto;
import smtrpz.mineappgateway.dto.CombinedResponseDto;
import smtrpz.mineappgateway.entity.Car;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    CarClient carClient;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveCar(@Valid @RequestBody CarDto carDto) throws SQLException {
        return carClient.saveCar(carDto);
    }

    @GetMapping("")
    public CombinedResponseDto<Iterable<Car>> getCar() {
        return carClient.getCar();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @Valid @RequestBody CarDto carDto){
        carClient.update(id, carDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        carClient.deleteById(id);
    }

}