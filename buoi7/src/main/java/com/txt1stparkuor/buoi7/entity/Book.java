package com.txt1stparkuor.buoi7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = false)
    String name;
    String description;
    @Column(precision = 10, scale = 2)
    BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(
            foreignKeyDefinition =
                    "FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL")
    )
    Category category;
}
