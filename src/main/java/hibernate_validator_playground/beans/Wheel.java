package hibernate_validator_playground.beans;

import javax.validation.constraints.NotNull;

public class Wheel {

    @NotNull
    private String manufacturer;

    public Wheel(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
