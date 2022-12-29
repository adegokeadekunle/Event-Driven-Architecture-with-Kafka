package com.adekunle.orderservice.service;

import com.adekunle.basedomain.dto.Order;
import com.adekunle.basedomain.dto.OrderEvent;
import com.adekunle.orderservice.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderProducer orderProducer;

    @Override
    public ResponseEntity<String> createOrder(Order order) {
       order.setOrderId(UUID.randomUUID().toString());

       OrderEvent orderEvent = new OrderEvent();
       orderEvent.setStatus("PENDING");
       orderEvent.setMessage("Other status is currently on pending state");
       orderEvent.setOrder(order);

       orderProducer.sendMessage(orderEvent);

       return ResponseEntity.ok("Order created successfully");
    }
}
