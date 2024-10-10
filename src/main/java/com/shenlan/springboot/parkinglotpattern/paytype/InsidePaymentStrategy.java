package com.shenlan.springboot.parkinglotpattern.paytype;

public class InsidePaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateFee(long startTime) {
        long elapsedHours = (System.currentTimeMillis() - startTime) / (1000 * 60 * 60);
        return (elapsedHours < 0.5) ? 0 : Math.ceil(elapsedHours) * 5;
    }
}
