package com.example.demo.model;

import lombok.Data;

import java.util.Optional;

@Data
public class Customer {
    private Long id;

    private String name;

    private Adress adress;

    private Trip trip;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {};

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "\n, adress=" + Optional.ofNullable(adress).map(Adress::toString).orElse("NO ADRESS") +
                "\n, trip=" + Optional.ofNullable(trip).map(Trip::toString).orElse("NO TRIP") +
                '}';
    }
}
