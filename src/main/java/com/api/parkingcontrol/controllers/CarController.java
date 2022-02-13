package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DTO.CarDTO;
import com.api.parkingcontrol.models.Car;
import com.api.parkingcontrol.services.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Object> listCar () {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(carService.listAll());
    }

    @PostMapping
    public ResponseEntity<Object> createCar(@RequestBody @Valid CarDTO carDTO) {

        Car car = new Car();

        BeanUtils.copyProperties(carDTO, car);

        car.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
    }
}
