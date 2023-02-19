package com.okayreet.notification;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Value("${rabbitmq.exchanges.notification-exchange}")
    private String notificationExchange;

    @Value("${rabbitmq.queues.notification-queue}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.notification-routing-key}")
    private String notificationRoutingKey;

    @Bean
    public TopicExchange notificationTopicExchange() {
        return new TopicExchange(this.notificationExchange);
    }

    @Bean
    public Queue internalNotificationQueue() {
        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(internalNotificationQueue())
                .to(notificationTopicExchange())
                .with(this.notificationRoutingKey);
    }


    public String getNotificationExchange() {
        return notificationExchange;
    }

    public String getNotificationQueue() {
        return notificationQueue;
    }

    public String getNotificationRoutingKey() {
        return notificationRoutingKey;
    }

}
