package com.metalheart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@Slf4j
@EnableBinding(Processor.class)
@SpringBootApplication
public class DataFlowProcessor {

    public static void main(String[] args) {
        SpringApplication.run(DataFlowProcessor.class, args);
    }

    /*@Transformer(inputChannel = Processor.INPUT,
        outputChannel = Processor.OUTPUT)
    public Object transform(Long timestamp) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
        String date = dateFormat.format(timestamp);

        log.info("Processed: " + date);

        return date;
    }*/


    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Object transform(Long timestamp) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
        String date = dateFormat.format(timestamp);

        log.info("Processed: " + date);

        return date;
    }
}
