package com.metalheart;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableScheduling
@EnableBinding(Source.class)
@SpringBootApplication
public class DataSource {

    public static void main(String[] args) {
        SpringApplication.run(DataSource.class, args);
    }


    @Autowired
    private Source source;


    @Scheduled(fixedDelay = 1000)
    public void sendEvents() {
        long time = new Date().getTime();
        log.info("Created: " + time);
        this.source.output().send(MessageBuilder.withPayload(time).build());
    }

    /*@Bean
    @InboundChannelAdapter(
        value = Source.OUTPUT,
        poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public MessageSource<Long> timeMessageSource() {
        return () -> {
            long time = new Date().getTime();
            log.info("Created: " + time);
            return MessageBuilder.withPayload(time).build();
        };
    }*/
}
