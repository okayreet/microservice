package com.okayreet.notification;

import com.okayreet.rabbitmq.RabbitmqMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
        (
        scanBasePackages = {
                "com.okayreet.notification",
                "com.okayreet.rabbitmq"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.okayreet.clients.notification", "com.okayreet.clients.customer"}
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitmqMessageProducer producer,
//            OrderNotificationConfig orderNotificationConfig,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> {
//            producer.publish(
//                    orderNotificationConfig.getOrderExchange(),
//                    orderNotificationConfig.getOrderRoutingKey(),
//                    new Person("Ali", 18));
//
//            producer.publish(
//                    notificationConfig.getNotificationExchange(),
//                    notificationConfig.getNotificationRoutingKey(),
//                    new Person("Ali", 18));
//        };
//    }
//
//    record Person(String name, int age) {
//    }
}
