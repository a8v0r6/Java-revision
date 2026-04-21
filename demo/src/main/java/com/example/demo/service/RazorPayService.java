package com.example.demo.service;

public class RazorPayService implements PaymentService{

    public void processPayment(double amount) {
        System.out.println("RazorPayService.processPayment");
        // process via razorpay
    }
}
