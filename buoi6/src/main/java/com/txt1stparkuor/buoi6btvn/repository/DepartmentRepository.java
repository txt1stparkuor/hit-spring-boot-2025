package com.txt1stparkuor.buoi6btvn.repository;

import com.txt1stparkuor.buoi6btvn.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
