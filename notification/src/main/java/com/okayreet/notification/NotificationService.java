package com.okayreet.notification;

import com.okayreet.clients.customer.CustomerClient;
import com.okayreet.clients.customer.CustomerResponse;
import com.okayreet.clients.notification.NotificationResponse;
import com.okayreet.clients.order.OrderResponse;
import com.okayreet.rabbitmq.RabbitmqMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final RabbitmqMessageProducer rabbitmqMessageProducer;
    private final CustomerClient customerClient;
    private final NotificationConfig notificationConfig;

    public void setAndSendOrderNotification(OrderResponse orderResponse) {


        CustomerResponse customerResponse = customerClient.getCustomerResponseById(orderResponse.getCustomerId());

        if (customerResponse == null) {
            throw new NullPointerException("no customer found with id: " + orderResponse.getCustomerId());
        }

        notificationRepository.save(Notification.builder()
                .order_id(orderResponse.getOrderId())
                .message("Thanks for ordering").build());

        NotificationResponse notificationResponse = NotificationResponse.builder()
                .customerName(customerResponse.getName())
                .productName(orderResponse.getProductName())
                .quantity(orderResponse.getQuantity())
                .totalPayment(orderResponse.getTotalPayment())
                .orderedAt(orderResponse.getOrderedAt())
                .message("Order confirmed")
                .build();

        rabbitmqMessageProducer.publish(
                notificationConfig.getNotificationExchange(),
                notificationConfig.getNotificationRoutingKey(),
                notificationResponse
        );

    }
}
