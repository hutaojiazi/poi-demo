package com.poi.demo;

import com.poi.demo.service.TrailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    private final TrailService trailService;

    public ContextRefreshedListener(final TrailService trailService)
    {
        this.trailService = trailService;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event)
    {
        trailService.importFromCsv("BoulderTrailHeads.csv");
    }
}
