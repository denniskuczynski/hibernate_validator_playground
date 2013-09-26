package hibernate_validator_playground;

import hibernate_validator_playground.beans.*;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;

public class Test {

    private static Validator validator;

    public static void main(String[] args) {
        try {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();

            ArrayList<Wheel> wheels = new ArrayList<Wheel>();
            wheels.add(new Wheel("Firestone"));
            wheels.add(new Wheel("Firestone"));
            wheels.add(new Wheel("Firestone"));
            wheels.add(new Wheel("Firestone"));
            Car car = new Car("Toyota", "DD-AB-123", 4, wheels);

            System.out.println("Validating Car");
            Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );
            printViolations(constraintViolations);
        } catch(Throwable t) {
            System.out.println("Exception in Test");
            t.printStackTrace();
        }
    }

    private static void printViolations(Set<ConstraintViolation<Car>> violations) {
        System.out.println("Contraint Violations: "+violations.size());
        for (ConstraintViolation<Car> violation : violations) {
            System.out.println("Violation: "+violation.toString());
            System.out.println("Message: "+violation.getMessage());
        }
    }
}
