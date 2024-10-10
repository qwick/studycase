package com.shenlan.springboot.parkinglotpattern;

import com.shenlan.springboot.parkinglotpattern.car.Vehicle;

public class ParkingTicket {
    private Vehicle vehicle;
    private long startTime;
    private String spotId;

    public ParkingTicket(Vehicle vehicle, long startTime, String spotId) {
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.spotId = spotId;
    }

    public long getStartTime() {
        return startTime;
    }

    public String getSpotId() {
        return spotId;
    }
}

