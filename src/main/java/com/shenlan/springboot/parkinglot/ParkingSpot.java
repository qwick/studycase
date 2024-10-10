package com.shenlan.springboot.parkinglot;

public class ParkingSpot {
    private int spotNumber;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void vacate() {
        this.vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}

