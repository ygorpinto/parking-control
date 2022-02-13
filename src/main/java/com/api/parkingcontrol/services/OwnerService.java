package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.Owner;
import com.api.parkingcontrol.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OwnerService {
    final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public Owner save (Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> listAll() {
        return ownerRepository.findAll();
    }
}
