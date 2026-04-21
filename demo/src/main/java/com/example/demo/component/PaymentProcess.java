package com.example.demo.component;

import com.example.demo.service.PaymentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcess {
    private final PaymentService paymentService;
    public PaymentProcess(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostConstruct
    public void init() {
        paymentService.processPayment(30000);
    }
}
