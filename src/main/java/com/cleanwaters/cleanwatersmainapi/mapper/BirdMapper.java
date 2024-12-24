package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.BirdDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Bird;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BirdMapper extends BaseMapper<Bird, BirdDTO> {
}