package com.cleanwaters.cleanwatersmainapi.repository;

import com.cleanwaters.cleanwatersmainapi.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
}