package com.txt1stparkuor.buoi7.repository;


import com.txt1stparkuor.buoi7.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
