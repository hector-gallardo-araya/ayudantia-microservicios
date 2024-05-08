package com.mingeso.msorders.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DecreaseStockRequest {
    RequestProduct[] products;
}
