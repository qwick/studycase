package com.shenlan.springboot.parkinglotpattern.observer;

import com.shenlan.springboot.parkinglotpattern.ParkingTicket;
import com.shenlan.springboot.parkinglotpattern.car.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int totalSpots;
    private int availableSpots;
    private Map<String, ParkingSpot> spots;
    private List<Observer> observers = new ArrayList<>();

    public ParkingLot(int totalSpots) {
        this.totalSpots = totalSpots;
        this.availableSpots = totalSpots;
        this.spots = new HashMap<>();

        // 初始化停车位
        for (int i = 0; i < totalSpots; i++) {
            spots.put("Spot" + i, new ParkingSpot("Spot" + i));
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(availableSpots);
        }
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots.values()) {
            if (!spot.isOccupied()) {
                spot.park();
                availableSpots--;
                notifyObservers();
                return new ParkingTicket(vehicle, System.currentTimeMillis(), spot.getId());
            }
        }
        System.out.println("停车场已满");
        return null; // 停车场已满
    }

    public void leaveVehicle(String spotId) {
        ParkingSpot spot = spots.get(spotId);
        if (spot != null && spot.isOccupied()) {
            spot.leave();
            availableSpots++;
            notifyObservers();
        } else {
            System.out.println("停车位为空或不存在");
        }
    }

    public int getTotalAvailableSpots() {
        return availableSpots;
    }
}