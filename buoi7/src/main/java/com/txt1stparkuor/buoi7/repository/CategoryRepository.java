package com.txt1stparkuor.buoi7.repository;

import com.txt1stparkuor.buoi7.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
