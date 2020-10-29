package com.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    @KafkaListener(topics = "my-topic", clientIdPrefix = "myClientId")
    @SendTo("test-topic")
    public String handle(ConsumerRecord<String, String> record,
                       ConsumerRecordMetadata consumerRecordMetadata,
                       @Header(KafkaHeaders.GROUP_ID) String groupId) {
        System.out.println("[ 处理器开始处理消息 ]" + System.currentTimeMillis());
        System.out.println(record);
        String topic = consumerRecordMetadata.topic();
        Integer partition = consumerRecordMetadata.partition();
        Long offset = consumerRecordMetadata.offset();
        System.out.println("groupId:" + groupId + ",topic:" + topic + ",partition:" + partition + ",offset:" + offset);
        System.out.println("[ 处理器处理消息完成 ]" + System.currentTimeMillis());
        return record.value();
    }

}
