package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionTypeDTO;
import com.cleanwaters.cleanwatersmainapi.entity.PollutionType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PollutionTypeMapper extends BaseMapper<PollutionType, PollutionTypeDTO> {
}