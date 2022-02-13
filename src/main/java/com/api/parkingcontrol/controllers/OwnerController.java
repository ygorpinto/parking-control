package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.DTO.OwnerDTO;
import com.api.parkingcontrol.models.Owner;
import com.api.parkingcontrol.services.OwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<Object> listAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ownerService.listAll());
    }

    @PostMapping
    public ResponseEntity<Object> createOwner(@RequestBody @Valid OwnerDTO ownerDTO) {

        Owner owner = new Owner();

        BeanUtils.copyProperties(ownerDTO, owner);

        owner.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.save(owner));
    }
}
