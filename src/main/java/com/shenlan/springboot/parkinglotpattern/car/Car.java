package com.shenlan.springboot.parkinglotpattern.car;

import com.shenlan.springboot.parkinglotpattern.Vehicle;

class Car implements Vehicle {
    private String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }
}