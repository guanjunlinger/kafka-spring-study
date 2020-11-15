package com.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.adapter.BatchToRecordAdapter;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;

import java.util.List;

public class MyBatchToRecordAdapter<K, V> implements BatchToRecordAdapter<K, V> {
    private final ConsumerRecordRecoverer recover;


    public MyBatchToRecordAdapter() {
        this.recover = (consumerRecord, ex) ->
                System.out.println(ex);
    }

    @Override
    public void adapt(List<Message<?>> messages, List<ConsumerRecord<K, V>> records,
                      Acknowledgment ack, Consumer<?, ?> consumer
            , Callback<K, V> callback) {

        for (int i = 0; i < messages.size(); i++) {
            Message<?> message = messages.get(i);
            try {
                System.out.println("开始处理第 " + i + " 条消息," + message.getPayload());
                callback.invoke(records.get(i), ack, consumer, message);
                System.out.println("结束处理第 " + i + " 条消息," + message.getPayload());
            } catch (Exception e) {
                this.recover.accept(records.get(i), e);
            }
        }

    }
}

