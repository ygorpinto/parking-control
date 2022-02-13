package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DTO.CarDTO;
import com.api.parkingcontrol.DTO.OwnerDTO;
import com.api.parkingcontrol.DTO.ParkingSpotDTO;
import com.api.parkingcontrol.models.ParkingSpot;
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

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping
    public ResponseEntity<Object> listAllParking() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(parkingSpotService.listAll());
    }

    @PostMapping
    public ResponseEntity<Object> createParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {

        ParkingSpot parkingSpot = new ParkingSpot();

        BeanUtils.copyProperties(parkingSpotDTO, parkingSpot);

        parkingSpot.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpot));
    }
}
