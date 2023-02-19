package com.okayreet.clients.order;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "ORDER",
        path = "api/v1/order"
)
public interface OrderClient {

}
