package com.okayreet;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {

    private Long customerId;
    private Long productId;
    private Integer quantity;
    private LocalDateTime orderedAt;
    private Double totalPayment;
}
