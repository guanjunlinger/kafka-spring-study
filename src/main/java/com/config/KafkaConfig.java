package com.config;

import com.handler.MyRecordInterceptor;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaConfig {


    @Bean
    ProducerListener producerListener() {
        return new MyProducerListener();
    }


    @Bean
    public RecordInterceptor RecordInterceptor() {
        return new MyRecordInterceptor();
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ConsumerFactory<Object, Object> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.setRecordFilterStrategy(new MyRecordFilterStrategy());
        factory.setRecoveryCallback(new MyRecoveryCallback());
        factory.setRetryTemplate(new RetryTemplate());
        return factory;
    }

}
