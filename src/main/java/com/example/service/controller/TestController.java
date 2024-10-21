package com.example.service.controller;

import com.example.service.service.PingPongService;
import com.example.service.service.TestService;
import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshotFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController()
@AllArgsConstructor
public class TestController {

    private final TestService testService;
    private final PingPongService pingPongService;

    @GetMapping("/api/v1/tests")
    List<String> getTest() {
        log.info("getTest");
        return testService.getTests();
    }

    @GetMapping("/api/v1/check")
    String check() {
        return pingPongService.check();
    }

    @GetMapping("/api/v1/multithread")
    String check2(@RequestParam int executors, @RequestParam int tasks) {
        log.info("check2 executors={}, tasks={}", executors, tasks);
        ContextSnapshotFactory snapshotFactory = ContextSnapshotFactory.builder().build();
        ExecutorService service = ContextExecutorService.wrap(Executors.newFixedThreadPool(executors), snapshotFactory::captureAll);

        var res = IntStream.rangeClosed(0, tasks)
                .mapToObj(id -> CompletableFuture.supplyAsync(pingPongService::check, service))
                .toList()
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.joining());

        return res;
    }
}
