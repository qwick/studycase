package com.shenlan.springboot.parkinglotpattern.car;

public class Car implements Vehicle {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}