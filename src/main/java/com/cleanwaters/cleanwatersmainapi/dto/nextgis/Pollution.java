package com.cleanwaters.cleanwatersmainapi.dto.nextgis;

import java.util.List;

public record Pollution(
        List<PollutionProperties> properties
) { }

