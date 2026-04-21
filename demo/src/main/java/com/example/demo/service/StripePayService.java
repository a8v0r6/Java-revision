package com.example.demo.service;


public class StripePayService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("StripePayService.processPayment");
        // process via stripe
    }
}
