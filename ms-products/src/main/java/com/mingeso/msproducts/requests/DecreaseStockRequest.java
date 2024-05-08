package com.mingeso.msproducts.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecreaseStockRequest {
    RequestProduct[] products;
}
