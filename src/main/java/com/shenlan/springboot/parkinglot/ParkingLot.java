package com.shenlan.springboot.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<ParkingArea> areas;

    public ParkingLot() {
        areas = new ArrayList<>();
        areas.add(new ParkingArea("Area A", 10));
        areas.add(new ParkingArea("Area B", 15));
    }

    public int getTotalAvailableSpots() {
        int count = 0;
        for (ParkingArea area : areas) {
            count += area.getAvailableSpots();
        }
        return count;
    }

    public ParkingArea getAreaWithMostSpots() {
        ParkingArea maxArea = areas.get(0);
        for (ParkingArea area : areas) {
            if (area.getAvailableSpots() > maxArea.getAvailableSpots()) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingArea area : areas) {
            ParkingTicket ticket = area.parkVehicle(vehicle);
            if (ticket != null) {
                return ticket;
            }
        }
        return null; // 无空位
    }
}

