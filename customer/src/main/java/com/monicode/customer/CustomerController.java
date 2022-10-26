package com.monicode.customer;

import com.monicode.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController{
    private final CustomerService customerService;

    @PostMapping
    public void registrationRequest(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping(path ="/firstname/{firstName}")
    public List<Customer> getByFirstName(@PathVariable("firstName") String firstName) {
        List<Customer> customers = customerService.getCustomersByFirstName(firstName);
        log.info("customers found by customer firstname {}", firstName);
        return customers;
    }

    @GetMapping(path ="/customerid/{id}")
    public @ResponseBody Customer getById(@PathVariable("id") Integer id) {
        Customer customer = customerService.getById(id);
        log.info("customer id {}", customer.getId());
        return customer;
    }
}
