package com.example.demo.model;

import lombok.Data;

@Data
public class AbroadTrip extends Trip {
    private double insurance;

    @Override
    public double getPrice() { return super.getPrice() + insurance; }

    @Override
    protected String checkIfAssignedPrice() {
        return (getPrice() <= insurance) ? "NO ASSIGNED PRICE" : super.checkIfAssignedPrice();
    }

    public AbroadTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
        insurance = 0;
    }
}
