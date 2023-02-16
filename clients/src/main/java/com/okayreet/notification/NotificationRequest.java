package com.okayreet.notification;

import lombok.Data;

import java.util.Date;

@Data
public class NotificationRequest {
    private Long orderId;
    private String message;
    private String productName;
    private Integer quantity;
    private Double totalPayment;
    private Date orderedAt;

}
