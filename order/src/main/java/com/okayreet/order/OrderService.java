package com.okayreet.order;

import com.okayreet.clients.order.OrderResponse;
import com.okayreet.clients.product.ProductClient;
import com.okayreet.clients.product.ProductResponse;
import com.okayreet.rabbitmq.RabbitmqMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
//    private final NotificationClient notificationClient;

    private final RabbitmqMessageProducer rabbitmqMessageProducer;

//    private NotificationConfig notificationConfig;

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
                .orderedAt(new Date())
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
                .quantity(orderRequest.getQuantity())
                .totalPayment(totalPayment)
                .orderedAt(order.getOrderedAt())
                .build();
//        notificationClient.setAndSendOrderNotification(orderResponse);
//        rabbitmqMessageProducer.publish(
//                notificationConfig.getInternalExchange(),
//                notificationConfig.getInternalNotificationRoutingKey(),
//                orderResponse
//        );

        rabbitmqMessageProducer.publish(
                "order-exchange",
                "order-routing-key",
                orderResponse
        );
    }
}