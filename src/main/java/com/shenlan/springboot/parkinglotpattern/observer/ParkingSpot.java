package com.shenlan.springboot.parkinglotpattern.observer;

public class ParkingSpot {
    private String id;
    private boolean isOccupied;

    public ParkingSpot(String id) {
        this.id = id;
        this.isOccupied = false; // 初始时停车位为空
    }

    public String getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void park() {
        isOccupied = true;
    }

    public void leave() {
        isOccupied = false;
    }
}