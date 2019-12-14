package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TravelOffice {
    private Map<Long, Customer> customerMap = new HashMap<>();
    {
        customerMap.put(1L, new Customer(1L, "Customer1"));
        customerMap.put(2L, new Customer(2L, "Customer2"));
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    public void removeCustomer(Long key) {
        customerMap.remove(key);
    }

    public Map<Long, Customer> getCustomersMap() {
        return customerMap;
    }

    @Override
    public String toString() {
        return "TravelOffice{" +
                "customerMap=" + customerMap +
                '}';
    }
}
