package com.shenlan.springboot.parkinglot;

import java.util.List;
import java.util.ArrayList;

class ParkingArea {
    private String name;
    private List<ParkingSpot> spots;

    public ParkingArea(String name, int totalSpots) {
        this.name = name;
        spots = new ArrayList<>();
        for (int i = 0; i < totalSpots; i++) {
            spots.add(new ParkingSpot(i + 1));
        }
    }

    public int getAvailableSpots() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.occupy(vehicle);
                return new ParkingTicket(spot);
            }
        }
        return null; // 无空位
    }

    public String getName() {
        return name;
    }
}

