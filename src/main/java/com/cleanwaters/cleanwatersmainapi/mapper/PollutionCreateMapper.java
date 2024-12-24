package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PollutionCreateDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Pollution;
import java.sql.Timestamp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PollutionCreateMapper {

  @Mapping(target = "createdAt", expression = "java(new java.sql.Timestamp(System.currentTimeMillis()))")
  @Mapping(target = "discoveredAt", source = "discoveredAt", qualifiedByName = "defaultDiscoveredAt")
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "deletedAt", ignore = true)
  Pollution toEntity(PollutionCreateDTO dto);

  @Named("defaultDiscoveredAt")
  default Timestamp defaultDiscoveredAt(Timestamp discoveredAt) {
    return discoveredAt != null ? discoveredAt : new Timestamp(System.currentTimeMillis());
  }
}