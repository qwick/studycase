package com.shenlan.springboot.parkinglotpattern.observer;

public class ParkingLotObserver implements Observer {
    @Override
    public void update(int availableSpots) {
        System.out.println("当前剩余停车位: " + availableSpots);
    }
}
