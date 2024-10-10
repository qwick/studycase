package com.shenlan.springboot.parkinglotpattern;


import com.shenlan.springboot.parkinglotpattern.car.Vehicle;
import com.shenlan.springboot.parkinglotpattern.car.VehicleFactory;
import com.shenlan.springboot.parkinglotpattern.observer.ParkingLot;
import com.shenlan.springboot.parkinglotpattern.observer.ParkingLotObserver;
import com.shenlan.springboot.parkinglotpattern.paytype.InsidePaymentStrategy;
import com.shenlan.springboot.parkinglotpattern.paytype.OutsidePaymentStrategy;
import com.shenlan.springboot.parkinglotpattern.paytype.PaymentStrategy;

public class Test {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10);
        lot.addObserver(new ParkingLotObserver());

        Vehicle vehicle1 = VehicleFactory.createVehicle("Car", "ABC123");
        Vehicle vehicle2 = VehicleFactory.createVehicle("Truck", "XYZ456");

        ParkingTicket ticket1 = lot.parkVehicle(vehicle1);
        ParkingTicket ticket2 = lot.parkVehicle(vehicle2);

        // 计算费用
        PaymentStrategy insidePayment = new InsidePaymentStrategy();
        PaymentStrategy outsidePayment = new OutsidePaymentStrategy();

        if (ticket1 != null) {
            System.out.println("停车收费（内部）： " + insidePayment.calculateFee(ticket1.getStartTime()) + "元");
        }
        if (ticket2 != null) {
            System.out.println("停车收费（出口）： " + outsidePayment.calculateFee(ticket2.getStartTime()) + "元");
        }

        // 离开车辆
        lot.leaveVehicle(ticket1.getSpotId());
        lot.leaveVehicle(ticket2.getSpotId());
    }
}
