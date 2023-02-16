package com.okayreet.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime orderedAt;
}
