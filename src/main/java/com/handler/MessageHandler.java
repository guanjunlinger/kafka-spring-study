package com.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    @KafkaListener(topics = {"my-topic"})
    public void handle(String message) {
        System.out.println("[ 处理器开始处理消息 ]" + System.currentTimeMillis());
        System.out.println(message);
        System.out.println("[ 处理器处理消息完成 ]" + System.currentTimeMillis());
    }

    @KafkaListener(topics = {"my-topic"})
    public void handle(ConsumerRecord<String, String> record) {
        System.out.println("[ 处理器开始处理消息 ]" + System.currentTimeMillis());
        System.out.println(record);
        System.out.println("[ 处理器处理消息完成 ]" + System.currentTimeMillis());
    }

}
