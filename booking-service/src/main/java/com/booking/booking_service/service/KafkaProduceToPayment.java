package com.booking.booking_service.service;

import org.common.dtoPaymentAndBooking.PaymentRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduceToPayment {
    @Autowired
    private KafkaTemplate<String, PaymentRequestEvent> kafkaTemplate;

    public void sendPaymentRequest(PaymentRequestEvent event) {

        Message<PaymentRequestEvent> message = MessageBuilder.
                withPayload(event)
                .setHeader(KafkaHeaders.TOPIC,"payment-request")
                .build();

        kafkaTemplate.send(message);
    }
}
