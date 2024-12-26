package com.cleanwaters.cleanwatersmainapi.config;

import com.cleanwaters.cleanwatersmainapi.service.NextGisPullDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class NextGisPullScheduledConfig {

    private final NextGisPullDataService nextGisPullDataService;

    @Scheduled(cron = "0 */1 */1 * * *") //todo move to ENV_VAR
    public void startPulling() {
        log.info("Starting pulling data from NextGis...");
        nextGisPullDataService.pullData();
        log.info("Finished pulling data from NextGis.");
    }
}
