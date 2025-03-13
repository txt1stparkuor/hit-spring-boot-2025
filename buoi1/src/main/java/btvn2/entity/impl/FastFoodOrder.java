package btvn2.entity.impl;

import btvn2.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class FastFoodOrder implements Order {
    @Override
    public void placeOrder() {
        System.out.println("Ordering fast food..");
    }
}
