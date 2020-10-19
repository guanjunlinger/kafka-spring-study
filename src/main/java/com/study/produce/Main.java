package com.study.produce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;

public class Main {

    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(KafkaConfig.class);
        KafkaTemplate<String, String> kafkaTemplate = annotationConfigApplicationContext.getBean(KafkaTemplate.class);
        kafkaTemplate.send("my-topic", "111", "222");
        kafkaTemplate.flush();
    }
}
