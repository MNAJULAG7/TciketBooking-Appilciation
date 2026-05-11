package com.booking.booking_service.service;

import com.booking.booking_service.entity.Booking;
import com.booking.booking_service.entity.BookingStatus;
import com.booking.booking_service.repository.BookingRepo;
import org.common.dtoPaymentAndBooking.PaymentStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerFromPayment {
    @Autowired
    FromSeatService seatService;

    @Autowired
    BookingRepo repo;


    @KafkaListener(topics = "payment-status", groupId = "booking-group")
    public void handlePayment(PaymentStatusEvent event) {

        System.out.println("Payment Status: " + event.getStatus());

        Booking b = repo.findById(event.getBookingId())
                .orElseThrow(()->new RuntimeException("booking is not created yet ..."));
        if (event.getStatus().equals("SUCCESS")) {

            seatService.markingTheStatus(b.getSeatId(),true);
            b.setStatus(BookingStatus.CONFIRMED);
            repo.save(b);


        } else {
            seatService.markingTheStatus(b.getSeatId(),false);
            b.setStatus(BookingStatus.FAILED);
            repo.save(b);

        }
    }
}
