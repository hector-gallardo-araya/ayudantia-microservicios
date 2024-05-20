package com.mingeso.msproducts.controllers;

import com.mingeso.msproducts.entities.Product;
import com.mingeso.msproducts.requests.DecreaseStockRequest;
import com.mingeso.msproducts.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping
    public ResponseEntity<String> decreaseStock(@RequestBody DecreaseStockRequest decreaseStockRequest) {
        this.productService.decreaseStock(decreaseStockRequest);
        return new ResponseEntity<>(
                "stock disminuido con éxito",
                HttpStatus.OK
        );
    }
}
