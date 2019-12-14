package com.example.demo.model;

import lombok.Data;

@Data
public class Trip {
    private MyDate start;
    private MyDate end;

    private String destination;

    private double price;

    public Trip(MyDate start, MyDate end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    public Trip() {}

    private String getPriceString() {
        return ((Double)getPrice()).toString();
    }

    protected String checkIfAssignedPrice() {
        return (getPrice() <= 0) ? "NO ASSIGNED PRICE" : getPriceString();
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price='" + checkIfAssignedPrice() + '\'' +
                '}';
    }
}
