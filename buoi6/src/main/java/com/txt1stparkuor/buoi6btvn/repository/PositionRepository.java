package com.txt1stparkuor.buoi6btvn.repository;

import com.txt1stparkuor.buoi6btvn.domain.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdNot(String title, Long id);
}
