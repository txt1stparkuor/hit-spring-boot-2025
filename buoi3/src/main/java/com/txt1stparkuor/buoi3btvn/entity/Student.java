package com.txt1stparkuor.buoi3btvn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "full_name", nullable = false, length = 100)
    @NotEmpty
    private String name;
    @Email
    @Column(unique = true, length = 150)
    private String email;
    @Column(name="phone_number",length = 15)
    private String phone;
    @Column(name = "home_address", columnDefinition = "text")
    private String address;
}
