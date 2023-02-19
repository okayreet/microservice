package com.okayreet.clients.notification;

import com.okayreet.clients.order.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "NOTIFICATION",
        path = "api/v1/notification"
)
public interface NotificationClient {
    @PostMapping("/order")
    void setAndSendOrderNotification(@RequestBody OrderResponse orderResponse);
}
