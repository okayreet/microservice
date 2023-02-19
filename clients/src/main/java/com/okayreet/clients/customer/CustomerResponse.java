package com.okayreet.clients.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Integer telephoneNumber;
    private String email;
    private String address_1;
    private String address_2;
    private String city;
    private String postCode;
}
