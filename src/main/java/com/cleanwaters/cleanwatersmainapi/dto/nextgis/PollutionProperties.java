package com.cleanwaters.cleanwatersmainapi.dto.nextgis;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PollutionProperties(
        String lat,
        String lon,
        String comment,
        @JsonProperty("type_surf")
        String surfaceType,
        @JsonProperty("status_us")
        String status,
        String source,
        @JsonProperty("dt")
        String dateTime,
        @JsonProperty("dt_auto")
        String dtAuto,
        String priority
) {
}
