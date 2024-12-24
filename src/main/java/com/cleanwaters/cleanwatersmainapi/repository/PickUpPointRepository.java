package com.cleanwaters.cleanwatersmainapi.repository;

import com.cleanwaters.cleanwatersmainapi.entity.PickUpPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickUpPointRepository extends JpaRepository<PickUpPoint, Long> {
}