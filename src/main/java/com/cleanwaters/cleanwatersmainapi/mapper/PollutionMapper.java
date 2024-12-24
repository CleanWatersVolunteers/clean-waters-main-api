package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollutionMapper extends BaseMapper<Pollution, PollutionDTO> {
}