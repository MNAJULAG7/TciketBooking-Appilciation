package com.booking.booking_service.service;

import com.booking.booking_service.payload.BookingRequest;

public interface BookingService {
     void bookingTheEvent(BookingRequest request, Long userid, String paymentMethod);
}
