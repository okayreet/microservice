package com.okayreet;

import com.okayreet.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long product_id) {
        return productRepository.findById(product_id).get();
    }

    public ProductResponse getProductResponseById(Long product_id) {
        Product product = productRepository.findById(product_id).get();
        ProductResponse productResponse = ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
}
