package com.api.parkingcontrol.DTO;
import javax.validation.constraints.NotBlank;

public class CarDTO {

    @NotBlank
    private String carIdentifier;

    @NotBlank
    private String carBrand;

    @NotBlank
    private String carModel;

    @NotBlank
    private String carColor;

    public String getCarIdentifier() {
        return carIdentifier;
    }

    public void setCarIdentifier(String carIdentifier) {
        this.carIdentifier = carIdentifier;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
