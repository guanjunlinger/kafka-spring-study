package com.config;

import com.handler.MyRecordInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

//    @Bean(name = "topic1")
//    public NewTopic topic() {
//        return TopicBuilder.name("topic1")
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }

    @Bean
    ProducerListener producerListener() {
        return new MyProducerListener();
    }

    @Bean
    public RecordInterceptor RecordInterceptor() {
        return new MyRecordInterceptor();
    }
}
