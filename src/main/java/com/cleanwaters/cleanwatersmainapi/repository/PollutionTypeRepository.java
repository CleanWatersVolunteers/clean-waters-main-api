package com.cleanwaters.cleanwatersmainapi.repository;

import com.cleanwaters.cleanwatersmainapi.entity.PollutionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollutionTypeRepository extends JpaRepository<PollutionType, Long> {
    //TODO pollution type can be enum value, join is unnecessary.
}