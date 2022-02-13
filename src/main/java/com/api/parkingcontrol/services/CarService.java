package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.Car;
import com.api.parkingcontrol.repositories.CarRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {
    final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    public Car save (Car car) {
        return carRepository.save(car);
    }

    public List<Car> listAll () {
        return carRepository.findAll();
    }
}
