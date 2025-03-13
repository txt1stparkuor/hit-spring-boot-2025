package btvn1;

import btvn1.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Btvn1Application {
    public static void main(String[] args) {
        SpringApplication.run(Btvn1Application.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext("btvn1");
        Person person=context.getBean(Person.class);
        person.driveVehicle();
        person.showEngine();
    }
}
