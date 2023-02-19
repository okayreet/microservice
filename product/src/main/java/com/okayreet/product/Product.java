package com.okayreet.product;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @SequenceGenerator(name = "product_id_sequence", sequenceName = "product_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_sequence")
    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
}
