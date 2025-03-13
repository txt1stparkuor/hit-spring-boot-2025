package btvn2;

import btvn1.entity.Person;
import btvn2.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Btvn2Application {
    public static void main(String[] args) {
        SpringApplication.run(btvn1.Btvn1Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("btvn2");
        Customer Customer=context.getBean(Customer.class);
        Customer.orderFood();
        Customer.payingBill();
    }
}