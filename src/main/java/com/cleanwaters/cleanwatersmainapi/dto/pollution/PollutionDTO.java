package com.cleanwaters.cleanwatersmainapi.dto.pollution;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PollutionDTO(
        Long id,
        String longitude,
        String latitude,
        String comment,
        String status,
        String infoSource,
        String surfaceType,
        LocalDateTime discoveredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }