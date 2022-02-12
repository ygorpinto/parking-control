package com.api.parkingcontrol.DTO;
import javax.validation.constraints.NotBlank;

public class OwnerDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
