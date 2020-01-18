package com.metalheart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkApp {

    @StreamListener(Sink.INPUT)
    public void loggerSink(String date) {

        log.info("Received: " + date);
    }

    public static void main(String[] args) {
        SpringApplication.run(SinkApp.class, args);
    }
}