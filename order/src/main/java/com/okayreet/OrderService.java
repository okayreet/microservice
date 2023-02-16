package com.okayreet;

import com.okayreet.notification.NotificationClient;
import com.okayreet.order.OrderResponse;
import com.okayreet.product.ProductClient;
import com.okayreet.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final NotificationClient notificationClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long order_id) {
        return orderRepository.findById(order_id).get();
    }

    public void makeOrder(OrderRequest orderRequest) {

        ProductResponse productResponse = productClient.getProductResponseById(orderRequest.getProductId());

        if (productResponse == null) {
            throw new NullPointerException("no price found");
        }

        Double totalPayment = productResponse.getPrice() * orderRequest.getQuantity();

        Order order = Order.builder()
                .customerId(orderRequest.getCustomerId())
                .productId(orderRequest.getProductId())
                .orderedAt(LocalDateTime.now())
                .price(productResponse.getPrice())
                .quantity(orderRequest.getQuantity())
                .totalPayment(totalPayment)
                .build();
        orderRepository.saveAndFlush(order);

//        OrderNotificationResponse orderNotificationResponse =
//                OrderNotificationResponse.builder()
//                        .customerName(customerResponse.getName())
//                        .productName(productResponse.getName())
//                        .quantity(orderRequest.getQuantity())
//                        .totalPayment(totalPayment)
//                        .orderedAt(LocalDateTime.now())
//                        .build();

        OrderResponse orderResponse = OrderResponse.builder()
                .customerId(orderRequest.getCustomerId())
                .orderId(order.getId())
                .productName(productResponse.getName())
                .orderedAt(order.getOrderedAt())
                .quantity(orderRequest.getQuantity())
                .totalPayment(totalPayment)
                .build();
        notificationClient.setAndSendOrderNotification(orderResponse);

    }
}