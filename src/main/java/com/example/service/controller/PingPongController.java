package com.example.service.controller;

import com.example.service.service.PingPongService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@AllArgsConstructor
@RestController
public class PingPongController {
private final PingPongService pingPongService;

    @GetMapping("/api/v1/ping")
    String ping(){
        log.info("ping");
        return pingPongService.processPing();
    }

    @GetMapping("/api/v1/pong")
    String pong(){
        return pingPongService.processPong();
    }
}
