package com.config;


import org.springframework.boot.autoconfigure.kafka.DefaultKafkaConsumerFactoryCustomizer;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyConsumerFactoryCustomizer implements DefaultKafkaConsumerFactoryCustomizer {
    @Override
    public void customize(DefaultKafkaConsumerFactory<?, ?> consumerFactory) {
        consumerFactory.addListener(new MyConsumerFactoryListener<>());
    }
}
