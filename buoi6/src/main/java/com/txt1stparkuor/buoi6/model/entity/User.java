package com.txt1stparkuor.buoi6.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(insertable = false, updatable = false, nullable = false)
    String id;
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    @JsonIgnore
    String password;
    @Column(nullable = false)
    @Nationalized
    String firstName;
    @Column(nullable = false)
    @Nationalized
    String lastName;
}
