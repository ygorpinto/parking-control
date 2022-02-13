package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParkingSpotService {
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> listAll () {
        return parkingSpotRepository.findAll();
    }

    @Transactional
    public ParkingSpot save (ParkingSpot parkingSpot) {
       return parkingSpotRepository.save(parkingSpot);
    }
}
