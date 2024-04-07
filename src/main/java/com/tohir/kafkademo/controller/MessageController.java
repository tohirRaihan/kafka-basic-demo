package com.tohir.kafkademo.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tohir.kafkademo.service.kafka.KafkaProducer;
import com.tohir.kafkademo.utils.constant.KafkaConstants;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(KafkaConstants.TOPIC_LOGS, LocalDateTime.now().toString(), message);
        return ResponseEntity.ok("Message sent to the Topic!!!");
    }
    
}
