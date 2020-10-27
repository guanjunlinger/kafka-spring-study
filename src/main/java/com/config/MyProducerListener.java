package com.config;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

public class MyProducerListener implements ProducerListener<String, String> {
    public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
        System.out.println("线程:" + Thread.currentThread().getId() + "发送:" + producerRecord + ",成功");
    }


    public void onError(ProducerRecord<String, String> producerRecord, Exception exception) {
        System.out.println("线程:" + Thread.currentThread().getId() + "发送:" + producerRecord + ",失败");
    }

}
