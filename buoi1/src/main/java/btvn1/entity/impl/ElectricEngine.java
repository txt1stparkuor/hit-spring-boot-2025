package btvn1.entity.impl;

import btvn1.entity.IEngine;
import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements IEngine {
    @Override
    public void displayEngineType() {
        System.out.println("Using electric engine");
    }
}
