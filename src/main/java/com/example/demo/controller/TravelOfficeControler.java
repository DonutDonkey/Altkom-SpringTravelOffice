package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.TravelOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TravelOfficeControler {
    @Autowired
    TravelOffice travelOffice;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        travelOffice.addCustomer(customer);
        return customer;
    }

    @PostMapping
    public void removeCustomer(@RequestBody Long key){ travelOffice.removeCustomer(key); }

    @GetMapping("/getAllCustomers")
    public Map<Long, Customer> getAllCustomers() { return new HashMap<>(travelOffice.getCustomersMap()); }
}
