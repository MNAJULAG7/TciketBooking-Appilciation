package com.booking.payment_service.service;


import com.booking.payment_service.entity.Payment;
import com.booking.payment_service.repository.PaymentRepo;
import org.common.dtoPaymentAndBooking.PaymentRequestEvent;
import org.common.dtoPaymentAndBooking.PaymentStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class KafkaPaymentConsumer {



    @Autowired
    private KafkaTemplate<String, PaymentStatusEvent> kafkaTemplate;

    @Autowired
    PaymentRepo repo;

    @KafkaListener(topics = "payment-request", groupId = "payment-group")
    public void processPayment(PaymentRequestEvent event) {

        System.out.println("Received Payment Request: " + event.getBookingId());

        if (repo.existsByBookingId(event.getBookingId())) {
            System.out.println("Already processed booking: " + event.getBookingId());
            return;
        }

        // simulate payment
        boolean success = false;
        if (event.getAmount() > 0) {

            // 🔷 Step 2: Simulate payment logic
            if ("UPI".equalsIgnoreCase(event.getPaymentMethod())) {
                success = true;
            } else if ("CARD".equalsIgnoreCase(event.getPaymentMethod())) {
                success = true;
            }
        }

        PaymentStatusEvent response = new PaymentStatusEvent();
        response.setBookingId(event.getBookingId());
        response.setStatus(success ? "SUCCESS" : "FAILED");

        Payment p = new Payment();
        p.setStatus(success ? "SUCCESS" : "FAILED");
        p.setBookingId(event.getBookingId());
        p.setAmount(event.getAmount());
        p.setCreatedAt(LocalDateTime.now());
        p.setMethod(event.getPaymentMethod());
        repo.save(p);

        kafkaTemplate.send("payment-status", response);
    }
}
