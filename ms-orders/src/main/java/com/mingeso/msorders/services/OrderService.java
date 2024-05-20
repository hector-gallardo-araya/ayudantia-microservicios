package com.mingeso.msorders.services;

import com.mingeso.msorders.clients.ProductsFeignClient;
import com.mingeso.msorders.entities.Order;
import com.mingeso.msorders.entities.OrderProduct;
import com.mingeso.msorders.repositories.OrderProductRepository;
import com.mingeso.msorders.repositories.OrderRepository;
import com.mingeso.msorders.requests.CreateOrderRequest;
import com.mingeso.msorders.requests.DecreaseStockRequest;
import com.mingeso.msorders.requests.RequestProduct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    OrderRepository orderRepository;
    OrderProductRepository orderProductRepository;
    ProductsFeignClient productsFeignClient;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        OrderProductRepository orderProductRepository,
                        ProductsFeignClient productsFeignClient) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productsFeignClient = productsFeignClient;
    }

    @Transactional
    public void createOrder(CreateOrderRequest createOrderRequest) {
        DecreaseStockRequest decreaseStockRequest = new DecreaseStockRequest();
        decreaseStockRequest.setProducts(createOrderRequest.getProducts());
        this.productsFeignClient.decreaseStock(decreaseStockRequest);

        Order order = new Order();
        order.setDescription(createOrderRequest.getDescription());
        order.setPaymentMethod(createOrderRequest.getPaymentMethod());
        order.setTotal(createOrderRequest.getTotal());
        order = this.orderRepository.save(order);

        //Podría verificar previamente que los productos existan

        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        for (RequestProduct product : createOrderRequest.getProducts()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrderId(order.getId());
            orderProduct.setProductId(product.getId());
            orderProduct.setQuantity(product.getQuantity());
            orderProducts.add(orderProduct);
        }

        this.orderProductRepository.saveAll(orderProducts);
    }

}
