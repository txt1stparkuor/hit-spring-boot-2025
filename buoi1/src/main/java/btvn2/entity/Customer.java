package btvn2.entity;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Customer {
    Order order;
    PaymentMethod paymentMethod;

    public Customer(@Qualifier("healthyFoodOrder") Order order,
                    @Qualifier("creditCardPayment") PaymentMethod paymentMethod) {
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public void orderFood() {
        order.placeOrder();
    }
    public void payingBill() {
        paymentMethod.pay();
    }
}
