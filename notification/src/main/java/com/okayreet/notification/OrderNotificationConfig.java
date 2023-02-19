package com.okayreet.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderNotificationConfig {
    @Value("${rabbitmq.exchanges.order-exchange}")
    private String orderExchange;

    @Value("${rabbitmq.queues.order-queue}")
    private String orderQueue;

    @Value("${rabbitmq.routing-keys.order-routing-key}")
    private String orderRoutingKey;

    @Bean
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(this.orderExchange);
    }

    @Bean
    public Queue orderInternalQueue() {
        return new Queue(this.orderQueue);
    }

    @Bean
    public Binding internalToOrderBinding() {
        return BindingBuilder
                .bind(orderInternalQueue())
                .to(orderTopicExchange())
                .with(this.orderRoutingKey);
    }


    public String getOrderExchange() {
        return orderExchange;
    }

    public String getOrderQueue() {
        return orderQueue;
    }

    public String getOrderRoutingKey() {
        return orderRoutingKey;
    }

}
