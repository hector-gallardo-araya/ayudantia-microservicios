package com.mingeso.msorders.services;

import com.mingeso.msorders.requests.CreateOrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void createOrder(CreateOrderRequest createOrderRequest) {
        System.out.println(createOrderRequest);
    }

}
