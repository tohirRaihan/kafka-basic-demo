package com.tohir.kafkademo.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tohir.kafkademo.dto.User;
import com.tohir.kafkademo.service.kafka.JsonKafkaProducer;
import com.tohir.kafkademo.utils.constant.KafkaConstants;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(KafkaConstants.TOPIC_LOGS_JSON, LocalDateTime.now().toString(), user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
