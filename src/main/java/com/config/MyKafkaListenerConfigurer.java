package com.config;

import org.springframework.kafka.annotation.KafkaListenerConfigurer;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MyKafkaListenerConfigurer implements KafkaListenerConfigurer {
    @Override
    public void configureKafkaListeners(KafkaListenerEndpointRegistrar kafkaListenerEndpointRegistrar) {
        System.out.println("ThreadId:" + Thread.currentThread().getId() + "开始配置KafkaListenerEndpointRegistrar实例");
        kafkaListenerEndpointRegistrar.setValidator(new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return false;
            }

            @Override
            public void validate(Object o, Errors errors) {

            }
        });
    }
}
