package com.txt1stparkuor.buoi4btvn.repositories;

import com.txt1stparkuor.buoi4btvn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
