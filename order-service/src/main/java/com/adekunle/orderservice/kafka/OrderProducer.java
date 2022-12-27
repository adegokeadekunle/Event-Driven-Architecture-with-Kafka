package com.adekunle.orderservice.kafka;

import com.adekunle.basedomain.dto.OrderEvent;

public interface OrderProducer {
    void sendMessage(OrderEvent orderEvent);
}
