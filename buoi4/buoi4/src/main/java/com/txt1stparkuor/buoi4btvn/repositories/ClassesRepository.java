package com.txt1stparkuor.buoi4btvn.repositories;

import com.txt1stparkuor.buoi4btvn.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes,Long> {
    Optional<Classes> findByName(String name);
}
