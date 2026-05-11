package com.booking.booking_service.controller;

import com.booking.booking_service.payload.BookingRequest;
import com.booking.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingService service;
    @PostMapping("/book/user/{userid}")
    public ResponseEntity<String> bookingTheEvent(@RequestBody BookingRequest request
    , @PathVariable long userid,@RequestParam String paymentMethod)
    {
       service.bookingTheEvent(request,userid,paymentMethod);
       return ResponseEntity.ok().body("sucessfully booked");
    }

}
