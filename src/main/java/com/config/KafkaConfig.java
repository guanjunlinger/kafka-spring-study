package com.config;

import com.handler.MyRecordInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;
import org.springframework.util.backoff.FixedBackOff;

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
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ConsumerFactory<Object, Object> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory();
        configurer.configure(factory, kafkaConsumerFactory);
        factory.setRecordFilterStrategy(new MyRecordFilterStrategy());
        factory.setStatefulRetry(true);
        factory.setRecoveryCallback(context -> {
            ConsumerRecord<?, ?> consumerRecord = (ConsumerRecord<?, ?>) context.getAttribute("record");
            Exception e = (Exception) context.getLastThrowable();
            System.out.println(e);
            return consumerRecord;
        });
        return factory;
    }

    @Bean
    public ErrorHandler eh() {
        return new SeekToCurrentErrorHandler(new FixedBackOff(0L, 3L));
    }
}
