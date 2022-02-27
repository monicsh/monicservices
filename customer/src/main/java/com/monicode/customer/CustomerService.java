package com.monicode.customer;

public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO : check email is valid
        // TODO : check email is not taken
        // TODO : store customer in db
    }
}
