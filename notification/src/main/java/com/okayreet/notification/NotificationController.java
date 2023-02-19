//package com.okayreet.notification;
//
//import com.okayreet.clients.order.OrderResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("api/v1/notification")
//@RestController
//public class NotificationController {
//    private final NotificationService notificationService;
//
//    @PostMapping("/order")
//    public void setAndSendOrderNotification(@RequestBody OrderResponse orderResponse) {
//        log.info("send notification");
//        notificationService.setAndSendOrderNotification(orderResponse);
//    }
//}
