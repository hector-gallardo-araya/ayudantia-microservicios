package com.mingeso.msorders.clients;

import com.mingeso.msorders.configurations.FeignClientConfig;
import com.mingeso.msorders.requests.DecreaseStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ms-products",
        path = "/products",
        configuration = {FeignClientConfig.class})
public interface ProductsFeignClient {
    @PutMapping
    String decreaseStock (@RequestBody DecreaseStockRequest decreaseStockRequest);
}
