package com.example.service.service;

import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Observed(name = "string-service")
@AllArgsConstructor
public class StringService {
    public String getString(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return String.valueOf(value);
    }
}
