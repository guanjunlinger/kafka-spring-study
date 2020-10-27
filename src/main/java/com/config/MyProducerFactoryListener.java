package com.config;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.ProducerFactory;

public class MyProducerFactoryListener<K,V> implements ProducerFactory.Listener<K, V> {

    public void producerAdded(String id, Producer<K, V> producer) {
        System.out.println("线程:" + Thread.currentThread().getId() + ",创建producer:" + id);
    }

    public void producerRemoved(String id, Producer<K, V> producer) {
        System.out.println("线程:" + Thread.currentThread().getId() + ",销毁producer:" + id);
    }

}
