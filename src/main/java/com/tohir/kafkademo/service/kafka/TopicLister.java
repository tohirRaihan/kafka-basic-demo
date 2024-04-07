package com.tohir.kafkademo.service.kafka;

import org.springframework.stereotype.Component;

import com.tohir.kafkademo.utils.constant.KafkaConstants;

/**
 * Kafka topic lists
 */
@Component
public class TopicLister {

    /**
     * List of kafka topics
     * @return String[]
     */
    public String[] getTopics() {
        return new String[] { KafkaConstants.TOPIC_LOGS, KafkaConstants.TOPIC_TEST };
    }

}
