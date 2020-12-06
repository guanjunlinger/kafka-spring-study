package com.handler;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "multi", topics = "test-topic")
public class MultiListenerBean {

    @KafkaHandler
    public void listen(String foo) {
        System.out.println(foo);
        throw new RuntimeException("1111");
    }
}
