package com.example.mineappclient.service;

import com.example.mineappclient.dto.CarDto;
import com.example.mineappclient.entity.Car;
import com.example.mineappclient.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getCar(){
        List<Car> list = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    public Car saveCar(CarDto carDto) {
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
        return carRepository.save(car);
    }

    @Transactional
    public Car update(Car oldCar) {
        Car car = carRepository.findById(oldCar.getId()).get();
        if(car != null) {
            BeanUtils.copyProperties(oldCar, car);
            return carRepository.save(car);
        }
        else {
            return carRepository.save(oldCar);
        }
    }

    public void deleteById(Long id){
        carRepository.deleteById(id);
    }
}