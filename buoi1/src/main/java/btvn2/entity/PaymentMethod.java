package btvn2.entity;

import org.springframework.stereotype.Component;

@Component
public interface PaymentMethod {
    void pay();
}
