package com.cleanwaters.cleanwatersmainapi.dto.nextgis;

import java.util.List;

public record PollutionResponse(
        List<Pollution> features
) { }
