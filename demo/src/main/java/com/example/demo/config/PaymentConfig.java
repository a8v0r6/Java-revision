package com.example.demo.config;

import com.example.demo.service.PaymentService;
import com.example.demo.service.RazorPayService;
import com.example.demo.service.StripePayService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    @ConditionalOnProperty(name = "payment.type", havingValue = "domestic")
    public PaymentService razorPayService() {
        return new RazorPayService();
    }

    @Bean
    @ConditionalOnProperty(name = "payment.type", havingValue = "international", matchIfMissing = true)
    public PaymentService stripePayService() {
        return new StripePayService();
    }
}
