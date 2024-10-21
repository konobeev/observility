package com.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ping-pong", url = "${app.feign.url}")
public interface PingPongClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/ping")
    String sendPing();

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/pong")
    String pong();
}
