package com.monicode.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(CustomerController.class)
@SpringBootTest
@AutoConfigureMockMvc
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
        CustomerRegistrationRequest customerRegistrationRequest =
                new CustomerRegistrationRequest(
                "monika",
                "sharma",
                "msharma@gmail.com");

//        when(customerService.registerCustomer(customerRegistrationRequest));

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Objects.requireNonNull(objectToJson(customerRegistrationRequest))))
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("msharma@gmail.com"));
        System.out.println("Result Action: {}" +resultActions);
    }

    private String objectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch(JsonProcessingException e) {
            fail("Failed to convert object to Json");
            return null;
        }
    }
}
