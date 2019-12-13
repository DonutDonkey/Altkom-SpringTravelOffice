package com.example.demo.model;

import lombok.Data;

@Data
public class DomesticTrip extends Trip {
    private double ownArrivalDiscount;

    @Override
    public double getPrice() { return super.getPrice() - ownArrivalDiscount; }

    public DomesticTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
        ownArrivalDiscount = 0;
    }
}
