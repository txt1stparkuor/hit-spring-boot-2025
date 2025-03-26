package com.txt1stparkuor.buoi3.repository;

import com.txt1stparkuor.buoi3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
