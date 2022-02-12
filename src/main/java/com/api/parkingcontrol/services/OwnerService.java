package com.api.parkingcontrol.services;

import com.api.parkingcontrol.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
