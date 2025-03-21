package com.txt1stparkuor.buoi2btvn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="NhanVien")
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    @Id
    @Column(name = "id" , length=20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id ;
    @Column(name = "name" , length = 40)
    private String name ;
    @Column(name = "email" , length = 60)
    private String email ;
    @Column(name = "address",length = 100)
    private String address ;
    @Column(name = "phone" , length = 12)
    private String phone ;
}
