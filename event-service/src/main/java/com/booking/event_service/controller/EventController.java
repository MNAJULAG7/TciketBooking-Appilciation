package com.booking.event_service.controller;


import com.booking.event_service.payload.EventRequest;
import com.booking.event_service.payload.EventResponse;
import com.booking.event_service.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService service;

     @PostMapping("/add")
    public ResponseEntity<EventResponse> addEvent(@RequestBody EventRequest request)
     {
         return ResponseEntity.ok().body(service.addEvent(request));
     }
    @GetMapping("/{id}")
    public ResponseEntity<EventResponse>  getEventById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(service.getEventById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponse>  updateEvent(@PathVariable Long id,@RequestBody  EventRequest request)
    {
        return ResponseEntity.ok().body(service.upadateEvent(id,request));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>>  deleteById(@PathVariable Long id)
    { EventResponse ur = service.deleteById(id);
        Map<String,Object> m = new HashMap<>();
        m.put("message", "deleted succesfully");
        m.put("deleted Item",ur);

        return ResponseEntity.ok().body(m);

    }

    @GetMapping("/")
    public ResponseEntity<List<EventResponse>>  getAll()
    {
        return ResponseEntity.ok().body(service.getAll());

    }

    @GetMapping("/location")
    public ResponseEntity<List<EventResponse>>  getAllByLocation(@RequestParam String location)
    {
        return ResponseEntity.ok().body(service.getAllByLocation(location));

    }


    @GetMapping("/seat/{eventId}")
    public Long getById(@PathVariable Long eventId)
    {
        return service.seatGetByEventId(eventId);
    }

}

