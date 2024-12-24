package com.cleanwaters.cleanwatersmainapi.repository;

import com.cleanwaters.cleanwatersmainapi.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}