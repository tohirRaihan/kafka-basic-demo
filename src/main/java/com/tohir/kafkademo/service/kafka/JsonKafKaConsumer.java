package com.tohir.kafkademo.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tohir.kafkademo.dto.User;
import com.tohir.kafkademo.utils.constant.KafkaConstants;

@Service
public class JsonKafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafKaConsumer.class);

    @KafkaListener(topics = KafkaConstants.TOPIC_LOGS_JSON, groupId = "${spring.kafka.consumer.group-id}")
    public void onConsumed(ConsumerRecord<String, User> consumerRecord) {
        String topic = consumerRecord.topic();
        User user = consumerRecord.value();

        LOGGER.info("Received Message in group: {}, topic: {}, message: {}", "${spring.kafka.consumer.group-id}", topic,
                user);
    }

}
