package com.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.RecordInterceptor;

public class MyRecordInterceptor implements RecordInterceptor<String, String> {

    @Override
    public ConsumerRecord<String, String> intercept(ConsumerRecord<String, String> consumerRecord) {
        System.out.println("线程:" + Thread.currentThread().getId() + ",拦截消息:" + consumerRecord);
        return consumerRecord;
    }
}
