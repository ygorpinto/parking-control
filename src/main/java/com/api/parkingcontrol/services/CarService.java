package com.api.parkingcontrol.services;

import com.api.parkingcontrol.repositories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
