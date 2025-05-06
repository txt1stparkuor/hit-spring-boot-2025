package com.txt1stparkuor.buoi6btvn.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, length = 100)
    String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    String description;
    @OneToMany(mappedBy = "department")
    List<Employee> employees= new ArrayList<>();
}
