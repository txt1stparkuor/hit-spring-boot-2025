package btvn1.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class Person {
    IVehicle vehicle;
    IEngine engine;

    public Person(@Qualifier("motorbike") IVehicle vehicle, @Qualifier("electricEngine") IEngine engine) {
        this.vehicle = vehicle;
        this.engine = engine;
    }

    public void driveVehicle() {
        vehicle.drive();
    }
    public void showEngine() {
        engine.displayEngineType();
    }
}
