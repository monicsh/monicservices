package com.monicode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO : check email is valid
        // TODO : check email is not taken
        // TODO : check if fraudster
        // Store customer in db
        customerRepository.save(customer);

        // TODO : send notification
    }
}
