package com.okayreet.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private String customerName;
    private String message;
    private String productName;
    private Integer quantity;
    private Double totalPayment;
    private LocalDateTime orderedAt;

}
