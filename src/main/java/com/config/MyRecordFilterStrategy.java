package com.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;

public class MyRecordFilterStrategy implements RecordFilterStrategy {

    @Override
    public boolean filter(ConsumerRecord consumerRecord) {
        System.out.println("ThreadId:" + Thread.currentThread().getId() + "开始过滤消息:" + consumerRecord);
        return true;
    }
}
