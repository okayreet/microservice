package com.okayreet;

import com.okayreet.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerResponse getCustomerById(Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).get();
//        return new CustomerResponse(customer.getFirstName() + " "+ customer.getLastName()
//                , customer.getTelephoneNumber(), customer.getEmail());
        return CustomerResponse.builder()
                .id(customer_id)
                .name(customer.getFirstName() + " " + customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .telephoneNumber(customer.getTelephoneNumber())
                .email(customer.getEmail())
                .address_1(customer.getAddress_1())
                .address_2(customer.getAddress_2())
                .city(customer.getCity())
                .postCode(customer.getPostCode())
                .build();
    }
}