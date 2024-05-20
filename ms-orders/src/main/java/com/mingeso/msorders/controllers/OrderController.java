package com.mingeso.msorders.controllers;

import com.mingeso.msorders.entities.Order;
import com.mingeso.msorders.requests.CreateOrderRequest;
import com.mingeso.msorders.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> postOrders(@RequestBody CreateOrderRequest createOrderRequest) {
        this.orderService.createOrder(createOrderRequest);
        return new ResponseEntity<>(
                "orden creada con éxito",
                HttpStatus.OK
        );
    }
}
