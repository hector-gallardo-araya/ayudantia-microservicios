package com.mingeso.msproducts.services;

import com.mingeso.msproducts.entities.Product;
import com.mingeso.msproducts.repositories.ProductRepository;
import com.mingeso.msproducts.requests.DecreaseStockRequest;
import com.mingeso.msproducts.requests.RequestProduct;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void decreaseStock(DecreaseStockRequest decreaseStockRequest) {

        ArrayList<Product> productsToUpdate = new ArrayList<>();
        for(RequestProduct requestProduct : decreaseStockRequest.getProducts()) {
            Optional<Product> optionalProduct = this.productRepository.findById(requestProduct.getId());
            if(optionalProduct.isEmpty()) throw new BadRequestException("un producto no existe...");
            Product product = optionalProduct.get();

            product.setStock(product.getStock() - requestProduct.getQuantity());
            productsToUpdate.add(product);
        }
        this.productRepository.saveAll(productsToUpdate);
    }
}
