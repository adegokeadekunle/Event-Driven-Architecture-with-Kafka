package com.adekunle.orderservice.service;

import com.adekunle.basedomain.dto.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity<String>createOrder(Order order);
}
