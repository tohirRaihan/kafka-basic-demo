package com.tohir.kafkademo.utils.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaConstants {
    public static final String TOPIC_LOGS = "logs";
    public static final String TOPIC_TEST = "test";
    public static final String GROUP_ID = "myGroup";

}
