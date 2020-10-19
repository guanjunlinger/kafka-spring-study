package com.study.produce;

import org.apache.kafka.clients.producer.Producer;
import org.springframework.kafka.core.ProducerFactory;

public class MyProducerFactoryListener implements ProducerFactory.Listener<String,String> {

    public void producerAdded(String id, Producer<String, String> producer) {
       System.out.println("线程id:"+Thread.currentThread().getId()+",producerId:"+id+" 被创建");
    }

    public void producerRemoved(String id, Producer<String, String> producer) {
        System.out.println("线程id:"+Thread.currentThread().getId()+",producerId:"+id+" 被销毁");
    }

}
