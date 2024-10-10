package com.shenlan.springboot.parkinglot;

public class ParkingTicket {
    private ParkingSpot spot;
    private long startTime;

    public ParkingTicket(ParkingSpot spot) {
        this.spot = spot;
        this.startTime = System.currentTimeMillis();
    }

    public double calculateFee() {
        long elapsedHours = (System.currentTimeMillis() - startTime) / (1000 * 60 * 60);
        if (elapsedHours < 0.5) {
            return 0; // 半小时内免费
        } else {
            return Math.ceil(elapsedHours) * 5; // 每小时5元
        }
    }
}

