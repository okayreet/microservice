package com.okayreet.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
//        value = "PRODUCT",
        path = "api/v1/product",
        name = "product",
        url = "${clients.product.url}"
)
public interface ProductClient {

    @GetMapping("/{product_id}")
    ProductResponse getProductResponseById(@PathVariable("product_id") Long product_id);
}
