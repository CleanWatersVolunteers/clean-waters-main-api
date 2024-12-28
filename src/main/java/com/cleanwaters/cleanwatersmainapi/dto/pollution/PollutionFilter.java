package com.cleanwaters.cleanwatersmainapi.dto.pollution;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PollutionFilter(
        LocalDateTime discoveredBefore,
        LocalDateTime discoveredAfter,
        String infoSource,
        List<String> status,
        List<String> surfaceType
) {}
