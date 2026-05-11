package com.booking.event_service.service;

import com.booking.event_service.entity.Event;
import com.booking.event_service.exception.EventNotFoundException;
import com.booking.event_service.payload.EventRequest;
import com.booking.event_service.payload.EventResponse;
import com.booking.event_service.repository.EventRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImple implements EventService{
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EventRepo eventRepo;
    @Override
    public EventResponse addEvent(EventRequest request) {
        Event event = modelMapper.map(request,Event.class);
        Event es = eventRepo.save(event);
        EventResponse er = modelMapper.map(es,EventResponse.class);

        return er;
    }

    @Override
    public EventResponse getEventById(Long id) {
        Event event= eventRepo.findById(id).orElseThrow(()->new EventNotFoundException(id));
        EventResponse ur = modelMapper.map(event,EventResponse.class);
        return ur;
    }

    @Override
    public EventResponse upadateEvent(Long id, EventRequest request) {
        Event event = eventRepo.findById(id).orElseThrow(()->new EventNotFoundException(id));
        event.setDate(request.getDate());
        event.setEventname(request.getEventname());
        event.setLocation(request.getLocation());
        event.setTotal_seats(request.getTotal_seats());
        event.setAmount(request.getAmount());
        Event es = eventRepo.save(event);
        EventResponse ur = modelMapper.map(es,EventResponse.class);
        return ur;

    }

    @Override
    public EventResponse deleteById(Long id) {
        Event e = eventRepo.findById(id).orElseThrow(()->new EventNotFoundException(id));
        eventRepo.delete(e);
        EventResponse ur = modelMapper.map(e,EventResponse.class);
        return ur;
    }

    @Override
    public List<EventResponse> getAll() {
        List<Event> user = eventRepo.findAll();
        List<EventResponse> ur = user.stream()
                .map(u->modelMapper.map(u,EventResponse.class))
                .toList();
        return ur;
    }

    @Override
    public List<EventResponse> getAllByLocation(String location) {
        List<Event> user = eventRepo.findAllByLocation(location);
        List<EventResponse> ur = user.stream()
                .map(u->modelMapper.map(u,EventResponse.class))
                .toList();
        return ur;
    }

    @Override
    public Long seatGetByEventId(Long eventId) {
        Event event = eventRepo.findById(eventId).orElseThrow(()->new EventNotFoundException(eventId));
        return event.getTotal_seats();
    }
}
