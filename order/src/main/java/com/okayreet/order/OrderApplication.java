package com.okayreet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
        (scanBasePackages = {
                "com.okayreet.order",
                "com.okayreet.rabbitmq"
        })
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.okayreet.clients.product", "com.okayreet.clients.order", "com.okayreet.clients.notification"}
)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}