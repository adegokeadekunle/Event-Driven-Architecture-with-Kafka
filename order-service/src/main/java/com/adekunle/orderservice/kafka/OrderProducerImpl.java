package com.adekunle.orderservice.kafka;

import com.adekunle.basedomain.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducerImpl implements OrderProducer{

    private final NewTopic topic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @Override
    public void sendMessage(OrderEvent orderEvent) {
    log.info("Order event => {}",orderEvent.toString());

    //create a message using the Message class of springFrame work
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)  // passing the orderEvent payload
                .setHeader(KafkaHeaders.TOPIC, topic.name())  // passing the topic name in a message
                .build();

        kafkaTemplate.send(message);
                
    }
}
