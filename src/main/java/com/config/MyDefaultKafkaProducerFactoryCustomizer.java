package com.config;

import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyDefaultKafkaProducerFactoryCustomizer implements DefaultKafkaProducerFactoryCustomizer {

    @Override
    public void customize(DefaultKafkaProducerFactory<?, ?> producerFactory) {
       producerFactory.addListener(new MyProducerFactoryListener());
       producerFactory.setProducerPerThread(true);
    }
}
