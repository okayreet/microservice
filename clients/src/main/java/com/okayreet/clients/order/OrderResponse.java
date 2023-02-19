package com.okayreet.clients.order;

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
public class OrderResponse {
    private Long customerId;
    private Long orderId;
    private String productName;
    private Integer quantity;
    private Double totalPayment;
    private Date orderedAt;
}
