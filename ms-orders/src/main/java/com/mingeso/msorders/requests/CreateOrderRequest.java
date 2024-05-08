package com.mingeso.msorders.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrderRequest {
    String description;
    String paymentMethod;
    int total;
    int[] productIds;
}
