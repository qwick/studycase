package com.shenlan.springboot.parkinglotpattern.paytype;

public interface PaymentStrategy {
    double calculateFee(long startTime);
}
