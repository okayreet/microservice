package com.okayreet.notification.rabbitmq;

import com.okayreet.clients.order.OrderResponse;
import com.okayreet.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;
    @RabbitListener(queues = "${rabbitmq.queues.order-queue}")
    public void consumerOrder(OrderResponse orderResponse){
        System.out.println(orderResponse);
        log.info("Consumed {} from queue", orderResponse);
        notificationService.setAndSendOrderNotification(orderResponse);
    }
}
