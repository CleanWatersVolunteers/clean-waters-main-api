package com.cleanwaters.cleanwatersmainapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nextgis.blacksea-monitoring-api")
public record NextGisApiProperties(
        String pollutionsUrl,
        String birdsUrl,
        String pickupPointsUrl
) { }