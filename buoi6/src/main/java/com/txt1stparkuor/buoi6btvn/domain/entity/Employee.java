package com.txt1stparkuor.buoi6btvn.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employees")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    User user;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(
            foreignKeyDefinition =
                    "FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL")
    )
    Department department;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(
            foreignKeyDefinition =
                    "FOREIGN KEY (position_id) REFERENCES positions(id) ON DELETE SET NULL")
    )
    Position position;
    @Column(nullable = false, length = 100)
    String fullName;
    LocalDate dateOfBirth;
    LocalDate hiredDate;
    @Column(precision = 10, scale = 2)
    BigDecimal salary;
}
