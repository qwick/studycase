package com.shenlan.springboot.parkinglotpattern.car;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car(licensePlate);
        } else if (type.equalsIgnoreCase("Truck")) {
            return new Truck(licensePlate);
        }
        return null;
    }
}
