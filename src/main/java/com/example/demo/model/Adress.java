package com.example.demo.model;

import lombok.Data;

@Data
public class Adress {
    private String street;
    private String zip;
    private String city;

    public Adress(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public Adress() { }

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
