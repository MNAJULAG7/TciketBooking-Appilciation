package com.booking.booking_service.exception;

public class SeatNotAvailableException extends RuntimeException{
    public  SeatNotAvailableException(Long id)
    {
        super("Seatnumber "+id+" is not available now");
    }
}
