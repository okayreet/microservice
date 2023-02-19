package com.okayreet.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private String customerName;
    private String productName;
    private Integer quantity;
    private Double totalPayment;
    private Date orderedAt;
    private String message;

}
