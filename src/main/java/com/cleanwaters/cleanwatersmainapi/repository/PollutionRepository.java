package com.cleanwaters.cleanwatersmainapi.repository;

import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollutionRepository extends JpaRepository<Pollution, Long> {
}