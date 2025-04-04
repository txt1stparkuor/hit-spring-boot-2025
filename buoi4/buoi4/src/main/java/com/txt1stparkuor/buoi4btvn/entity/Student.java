package com.txt1stparkuor.buoi4btvn.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    LocalDate dob;
    Gender gender;
    String email;
    String phone;
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    Classes classes;
}
