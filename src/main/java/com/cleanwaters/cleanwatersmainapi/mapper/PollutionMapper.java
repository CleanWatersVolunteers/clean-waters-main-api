package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PollutionMapper extends BaseMapper<Pollution, PollutionDTO> {
  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntityFromDto(PollutionDTO dto, @MappingTarget Pollution entity);
}