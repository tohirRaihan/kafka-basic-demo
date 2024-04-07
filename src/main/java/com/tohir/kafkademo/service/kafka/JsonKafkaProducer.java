package com.tohir.kafkademo.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.tohir.kafkademo.dto.User;

import lombok.RequiredArgsConstructor;

@Service
@EnableAsync
@RequiredArgsConstructor
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Async
    public void sendMessage(String topicName, String messageId, User user) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .setHeader(KafkaHeaders.KEY, messageId)
                .build();

        kafkaTemplate.send(message);
    }

}
