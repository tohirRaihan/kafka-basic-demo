package com.tohir.kafkademo.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = "#{@topicLister.getTopics()}", groupId = "${spring.kafka.consumer.group-id}")
    public void onConsumed(ConsumerRecord<String, String> consumerRecord) {
        String topic = consumerRecord.topic();
        String message = consumerRecord.value();

        LOGGER.info("Received Message in group: {}, topic: {}, message: {}", "${spring.kafka.consumer.group-id}", topic,
                message);
    }

}
