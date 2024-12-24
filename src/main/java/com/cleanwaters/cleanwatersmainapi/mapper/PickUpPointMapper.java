package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.PickUpPointDTO;
import com.cleanwaters.cleanwatersmainapi.entity.PickUpPoint;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PickUpPointMapper extends BaseMapper<PickUpPoint, PickUpPointDTO> {
}