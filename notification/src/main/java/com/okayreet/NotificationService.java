package com.okayreet;

import com.okayreet.customer.CustomerClient;
import com.okayreet.customer.CustomerResponse;
import com.okayreet.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final CustomerClient customerClient;

    public void setAndSendOrderNotification(OrderResponse orderResponse) {


        CustomerResponse customerResponse = customerClient.getCustomerResponseById(orderResponse.getCustomerId());

        if (customerResponse == null) {
            throw new NullPointerException("no price found");
        }

        notificationRepository.save(Notification.builder()
                .order_id(orderResponse.getOrderId())
                .message("Thanks for ordering").build());


    }
}
