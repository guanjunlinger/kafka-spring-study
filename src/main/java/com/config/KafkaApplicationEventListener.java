package com.config;

import org.springframework.context.event.EventListener;
import org.springframework.kafka.event.ConsumerStartedEvent;
import org.springframework.kafka.event.ConsumerStartingEvent;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
public class KafkaApplicationEventListener {

    @EventListener(value = ConsumerStartingEvent.class)
    public void messageListener(ConsumerStartingEvent consumerStartingEvent) {
        MessageListenerContainer messageListenerContainer = (MessageListenerContainer) consumerStartingEvent.getSource();
        System.out.println(messageListenerContainer.getContainerProperties() + " 开始启动");
    }

    @EventListener(value = ConsumerStartedEvent.class)
    public void messageListener(ConsumerStartedEvent consumerStartedEvent) {
        MessageListenerContainer messageListenerContainer = (MessageListenerContainer) consumerStartedEvent.getSource();
        System.out.println(messageListenerContainer.getContainerProperties() + " 启动成功");
    }

}
