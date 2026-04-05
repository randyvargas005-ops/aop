package com.aon.aop;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Timed
    public void processPayment(double amount) throws InterruptedException {
        // Simulate some processing time
        Thread.sleep(100); // 100 ms
        System.out.println("Processed payment of $" + amount);
    }

    @Timed
    public int calculateDiscount(int price, int percentage) {
        // Simple calculation
        return price * percentage / 100;
    }
}
