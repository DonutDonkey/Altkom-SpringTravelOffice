package com.example.demo.controller;

import com.example.demo.model.Adress;
import com.example.demo.model.Customer;
import com.example.demo.model.MyDate;
import com.example.demo.model.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TravelOfficeApplicationTests {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllCustomerMap() throws Exception {
        this.mockMvc.perform(get("/getAllCustomers"))
                .andExpect(status().isOk());
    }

    @Test
    void addCustomer() throws Exception{
        Customer customer = createCustomer();
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("TestName");
    }

    private Customer createCustomer() throws Exception{
        Customer customer = getCustomer();

        String postValue = OBJECT_MAPPER.writeValueAsString(customer);

        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        return OBJECT_MAPPER.readValue(storyResult.getRequest().getContentAsString(), Customer.class);
    }

    private Customer getCustomer() {
        Customer customer = new Customer(80L,"TestName");
        customer.setAdress(new Adress("aaa","aaa","aaa"));

        customer.setTrip(new Trip(new MyDate(0,0,0),
                new MyDate(0,0,0),
                "aaa"));

        return customer;
    }
}
