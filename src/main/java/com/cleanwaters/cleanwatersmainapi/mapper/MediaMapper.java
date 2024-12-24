package com.cleanwaters.cleanwatersmainapi.mapper;

import com.cleanwaters.cleanwatersmainapi.dto.MediaDTO;
import com.cleanwaters.cleanwatersmainapi.entity.Media;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MediaMapper extends BaseMapper<Media, MediaDTO> {
}