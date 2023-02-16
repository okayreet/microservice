package com.okayreet;

import com.okayreet.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/notification")
@RestController
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping("/order")
    public void setAndSendOrderNotification(@RequestBody OrderResponse orderResponse) {
        log.info("send notification");
        notificationService.setAndSendOrderNotification(orderResponse);
    }
}
