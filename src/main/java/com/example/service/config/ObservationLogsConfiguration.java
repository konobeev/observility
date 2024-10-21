package com.example.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j()
@Configuration
public class ObservationLogsConfiguration {


//    @Bean
//    public ObservationTextPublisher observationTextPublisher() {
//        return new ObservationTextPublisher(
//                log::info,
//                context -> context
//                        .getLowCardinalityKeyValues()
//                        .stream()
//                        .anyMatch(keyValue -> keyValue.getKey().equals("context") && keyValue.getValue().equals("user")),
//                Observation.Context::getName);
//    }
}