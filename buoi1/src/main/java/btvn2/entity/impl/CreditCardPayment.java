package btvn2.entity.impl;

import btvn2.entity.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Paying via credit card");
    }
}
