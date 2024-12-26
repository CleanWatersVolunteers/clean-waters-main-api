package com.cleanwaters.cleanwatersmainapi.service;

import com.cleanwaters.cleanwatersmainapi.config.NextGisApiProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class NextGisPullDataService {

    private final NextGisApiProperties urls;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public void pullData() {
        log.info("Pulling pollutions data...");
    }
}
