package com.booking.seat_service.exception;

public class SeatNotFoundException extends RuntimeException{
    public  SeatNotFoundException(Long id)
    {
        super("Seat not found by the given id : "+id);
    }
}
