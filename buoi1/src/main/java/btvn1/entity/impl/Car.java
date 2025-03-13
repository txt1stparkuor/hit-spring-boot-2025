package btvn1.entity.impl;

import btvn1.entity.IVehicle;
import org.springframework.stereotype.Component;

@Component
public class Car implements IVehicle {
    @Override
    public void drive() {
        System.out.println("You are driving a car");
    }

}
