package com.shenlan.springboot.parkinglot;

public class Test {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        Vehicle vehicle1 = new Vehicle("ABC123");
        Vehicle vehicle2 = new Vehicle("XYZ456");

        ParkingTicket ticket1 = lot.parkVehicle(vehicle1);
        ParkingTicket ticket2 = lot.parkVehicle(vehicle2);

        System.out.println("剩余停车位: " + lot.getTotalAvailableSpots());
        System.out.println("停车区域较多: " + lot.getAreaWithMostSpots().getName());
        System.out.println("停车收费: " + ticket1.calculateFee() + "元（在停车场内收费）");

        // 假设在出口收费
        System.out.println("停车收费: " + ticket2.calculateFee() + "元（在出口收费）");
    }
}

