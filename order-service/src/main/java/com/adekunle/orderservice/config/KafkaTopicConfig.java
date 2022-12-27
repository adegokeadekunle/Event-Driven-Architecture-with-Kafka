package com.adekunle.orderservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public NewTopic topic(){
        return TopicBuilder
                .name(topicName)
           //     .partitions() u can add partitions
                .build();
    }
}
