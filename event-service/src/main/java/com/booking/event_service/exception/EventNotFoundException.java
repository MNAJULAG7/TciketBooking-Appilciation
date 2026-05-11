package com.booking.event_service.exception;

public class EventNotFoundException extends RuntimeException{
    public  EventNotFoundException(Long id)
    {
        super("Event not found by the given id : "+id);
    }
}
