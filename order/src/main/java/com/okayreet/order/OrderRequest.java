package com.okayreet.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {
    private Long customerId;
    private Long productId;
    private Integer quantity;
}
