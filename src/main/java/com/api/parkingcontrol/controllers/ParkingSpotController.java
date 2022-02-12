package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DTO.CarDTO;
import com.api.parkingcontrol.DTO.OwnerDTO;
import com.api.parkingcontrol.DTO.ParkingSpotDTO;
import com.api.parkingcontrol.models.Car;
import com.api.parkingcontrol.models.Owner;
import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.services.CarService;
import com.api.parkingcontrol.services.OwnerService;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking")
public class ParkingSpotController {

    final ParkingSpotService parkingSpotService;
    final OwnerService ownerService;
    final CarService carService;

    public ParkingSpotController(ParkingSpotService parkingSpotService, OwnerService ownerService, CarService carService) {
        this.parkingSpotService = parkingSpotService;
        this.ownerService = ownerService;
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Object> createParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO, OwnerDTO ownerDTO, CarDTO carDTO) {

        ParkingSpot parkingSpot = new ParkingSpot();
        Owner owner = new Owner();
        Car car = new Car();

        BeanUtils.copyProperties(parkingSpotDTO, parkingSpot);
        BeanUtils.copyProperties(ownerDTO, owner);
        BeanUtils.copyProperties(carDTO, car);

        parkingSpot.setDate(LocalDate.now());
        owner.setDate(LocalDate.now());
        car.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpot));
    }
}
