package com.okayreet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
        (scanBasePackages = {
                "com.okayreet.order",
                "com.okayreet.rabbitmq"
        })
@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.okayreet.clients.product", "com.okayreet.clients.order", "com.okayreet.clients.notification"}
)
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}