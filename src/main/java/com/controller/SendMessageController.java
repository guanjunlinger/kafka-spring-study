package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic = "my-topic";

    @GetMapping("/send")
    public String send(String params) {
        kafkaTemplate.sendDefault(topic, params);
        return "success";
    }

    @GetMapping("/send/handler")
    public String sendKafkaHandler(String params) {
        kafkaTemplate.send("test-topic", params);
        return "success";
    }

}
