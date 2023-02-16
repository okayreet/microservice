package com.okayreet;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_sequence")
    private Long id;
    private Long customerId;
    private Long productId;
    private LocalDateTime orderedAt;
    private Double price;
    private Integer quantity;
    private Double totalPayment;
}
