package com.txt1stparkuor.buoi6btvn.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "positions")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true, length = 100)
    String title;
    @Column(columnDefinition = "TEXT")
    String description;
    @OneToMany(mappedBy = "position")
    List<Employee> employees= new ArrayList<>();
}
