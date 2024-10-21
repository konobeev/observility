package com.example.service.service;

import com.example.service.client.PingPongClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@AllArgsConstructor
public class PingPongService {
    private final PingPongClient pingPongClient;

    public String check() {
        log.info("check");
        var res=  pingPongClient.sendPing();
        log.info("check response: {}", res);
        return res;
    }

    public String processPing() {
        log.info("ping");
        try {
            Thread.sleep(1000);
            return pingPongClient.pong();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public String processPong() {
        log.info("pong");
        try {
            Thread.sleep(1000);
            return "pong %s".formatted(Instant.now());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
