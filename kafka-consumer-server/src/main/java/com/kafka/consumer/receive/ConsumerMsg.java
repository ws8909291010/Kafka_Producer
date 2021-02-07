package com.kafka.consumer.receive;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerMsg {

    private static Logger LOGGER = LoggerFactory.getLogger(ConsumerMsg.class);

    @KafkaListener(topics = "demo_0207")
    public void listenMsg (ConsumerRecord<?,String> record) {
        String value = record.value();
        LOGGER.info("ConsumerMsg====>>"+value);
    }

}
