package hibernate_validator_playground.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import java.util.Collection;

public class Car {

    @NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;

    @NotNull
    @Size(min=4, max=4)
    @Valid
    private Collection<Wheel> wheels;

    public Car(String manufacturer, String licencePlate, int seatCount, Collection<Wheel> wheels) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
        this.wheels = wheels;
    }
}
