package com.booking.event_service.service;

import com.booking.event_service.payload.EventRequest;
import com.booking.event_service.payload.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse addEvent(EventRequest request);

    EventResponse getEventById(Long id);

    EventResponse upadateEvent(Long id, EventRequest request);

    EventResponse deleteById(Long id);

    List<EventResponse> getAll();

    List<EventResponse> getAllByLocation(String location);

    Long seatGetByEventId(Long eventId);
}
