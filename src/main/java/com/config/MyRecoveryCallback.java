package com.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryContext;

public class MyRecoveryCallback implements RecoveryCallback {

    @Override
    public Object recover(RetryContext retryContext){
        ConsumerRecord<?, ?> consumerRecord = (ConsumerRecord<?, ?>) retryContext.getAttribute("record");
        Exception e = (Exception) retryContext.getLastThrowable();
        System.out.println(e);
        return consumerRecord;
    }
}
