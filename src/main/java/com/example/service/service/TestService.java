package com.example.service.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@Slf4j
@Service
@AllArgsConstructor
public class TestService {
    private final Random random = new Random(System.currentTimeMillis());

    public List<String> getTests() {
        log.info("getTests");
        var pool = Executors.newFixedThreadPool(3);

        var tasks =  random.ints(10)
                .mapToObj(item -> CompletableFuture.<String>supplyAsync(()->this.getString(item), pool))
                .toList();
        return tasks.stream().map(CompletableFuture::join).toList();
    }

    String getString(int value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return String.valueOf(value);
    }
}
