package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PollutionCreateMapper {

  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  Pollution toEntity(PollutionCreateDTO dto);
}