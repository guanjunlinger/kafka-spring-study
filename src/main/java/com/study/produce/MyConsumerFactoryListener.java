package com.study.produce;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.core.ConsumerFactory;

public class MyConsumerFactoryListener implements ConsumerFactory.Listener<String, String> {
    public void consumerAdded(String id, Consumer<String, String> consumer) {
        System.out.println("线程id:" + Thread.currentThread().getId() + ",consumerId:" + id + " 被创建");
    }

    public void consumerRemoved(String id, Consumer<String, String> consumer) {
        System.out.println("线程id:" + Thread.currentThread().getId() + ",consumerId:" + id + " 被销毁");
    }

}
