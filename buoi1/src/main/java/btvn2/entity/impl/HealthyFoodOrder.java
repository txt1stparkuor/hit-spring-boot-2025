package btvn2.entity.impl;

import btvn2.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class HealthyFoodOrder implements Order {
    @Override
    public void placeOrder() {
        System.out.println("Ordering healthy food..");
    }
}
