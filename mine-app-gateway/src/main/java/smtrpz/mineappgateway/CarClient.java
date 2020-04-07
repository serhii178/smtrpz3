package smtrpz.mineappgateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smtrpz.mineappgateway.dto.ApiResponse;
import smtrpz.mineappgateway.dto.CarDto;
import smtrpz.mineappgateway.dto.CombinedResponseDto;
import smtrpz.mineappgateway.entity.Car;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@FeignClient("car-service")
@RequestMapping("/api/car")
public interface CarClient {

    @GetMapping("")
    public CombinedResponseDto<Iterable<Car>> getCar();

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> saveCar(@Valid @RequestBody CarDto carDto) throws SQLException;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update/{id}")
    public void update(@PathVariable(name = "id") Long id, @Valid @RequestBody CarDto carDto);


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id);
}
