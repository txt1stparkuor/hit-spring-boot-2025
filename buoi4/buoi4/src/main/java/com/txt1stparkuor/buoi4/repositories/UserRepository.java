package com.txt1stparkuor.buoi4.repositories;

import com.txt1stparkuor.buoi4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
