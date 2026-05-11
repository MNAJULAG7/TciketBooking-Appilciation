package com.booking.booking_service.service;

import com.booking.booking_service.entity.Booking;
import com.booking.booking_service.entity.BookingStatus;
import com.booking.booking_service.exception.SeatNotAvailableException;
import com.booking.booking_service.payload.*;

import com.booking.booking_service.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.common.dtoPaymentAndBooking.PaymentRequestEvent;
import org.common.dtoPaymentAndBooking.PaymentStatusEvent;

@Service
public class BookingServiceImple implements BookingService{
    @Autowired
    FromEventService eventService;

    @Autowired
    FromSeatService seatService;

    @Autowired
    BookingRepo  repo;

    @Autowired
    KafkaProduceToPayment kafkaProduceToPayment;



    @Override
    public void bookingTheEvent(BookingRequest request,Long userid,String paymentMethod) {
        EventResponse eventResponse = eventService.getEventById(request.getEventId()).getBody();
        if(eventResponse==null)
            throw  new RuntimeException("even is not available...");
        SeatResponse seatResponse = seatService.getSeatById(request.getSeatId()).getBody();
        if(seatResponse==null)
            throw  new RuntimeException("seat is not available...");

        if(!seatResponse.getStatus().equals("AVAILABLE"))
            throw new SeatNotAvailableException(request.getSeatId());

        seatService.markingAsLocked(request.getSeatId());

        Booking booking = new Booking(userid, request.getEventId(),request.getSeatId() );

        booking.setStatus(BookingStatus.PENDING);
        booking = repo.save(booking);


        PaymentRequestEvent event = new PaymentRequestEvent();
        event.setBookingId(booking.getId());
        event.setUserId(userid);
        event.setPaymentMethod(paymentMethod);
        event.setAmount(eventResponse.getAmount());

        kafkaProduceToPayment.sendPaymentRequest(event);
    }
}
