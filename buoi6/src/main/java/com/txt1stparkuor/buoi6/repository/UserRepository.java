package com.txt1stparkuor.buoi6.repository;

import com.txt1stparkuor.buoi6.model.dto.request.UserCreationRequest;
import com.txt1stparkuor.buoi6.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
