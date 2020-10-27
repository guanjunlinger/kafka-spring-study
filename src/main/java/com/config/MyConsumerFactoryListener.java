package com.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.core.ConsumerFactory;

public class MyConsumerFactoryListener<K, V> implements ConsumerFactory.Listener<K, V> {

    public void consumerAdded(String id, Consumer<K, V> consumer) {
        System.out.println("线程:" + Thread.currentThread().getId() + ",创建consumer:" + id);
    }

    public void consumerRemoved(String id, Consumer<K, V> consumer) {
        System.out.println("线程:" + Thread.currentThread().getId() + ",销毁consumer:" + id);
    }
}

