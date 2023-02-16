package com.okayreet.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "CUSTOMER",
        path = "api/v1/customer"
)
public interface CustomerClient {
    @GetMapping("/{customer_id}")
    CustomerResponse getCustomerResponseById(@PathVariable("customer_id") Long customer_id);
}
