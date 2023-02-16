package com.okayreet;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer telephoneNumber;
    private String email;
    private String address_1;
    private String address_2;
    private String city;
    private String postCode;
}
