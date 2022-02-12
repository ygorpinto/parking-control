package com.api.parkingcontrol.DTO;
import javax.validation.constraints.NotBlank;

public class ParkingSpotDTO {

    @NotBlank
    private String spotNumber;

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }
}
