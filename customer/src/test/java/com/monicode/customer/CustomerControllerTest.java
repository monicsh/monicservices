package com.monicode.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void getCustomerByIdAPI() throws Exception
    {
        Integer id = 1;
        Customer customer = new Customer(id,
                "monika",
                "sharma",
                "msharma@gmail.com");

        when(customerService.getById(id)).thenReturn(customer);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/customerid/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(customer.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.getEmail()));

    }

    @Test
    public void postCustomerAPI() throws Exception
    {
        Integer id = 1;
        Customer customer = new Customer(id,
                "monika",
                "sharma",
                "msharma@gmail.com");

        when(customerService.getById(id)).thenReturn(customer);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/customerid/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(customer.getFirstName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value(customer.getLastName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customer.getEmail()));

    }
}
