package com.booking.seat_service.controller;

import com.booking.seat_service.payload.RequestSeatNumber;
import com.booking.seat_service.payload.SeatResponse;
import com.booking.seat_service.service.SeatServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    SeatServiceImple service;
    @PostMapping("/allocate/{eventid}")
     public ResponseEntity<String> allocate(@PathVariable long eventid)
    {
        service.allocateSeats(eventid);
        return ResponseEntity.ok().body("seats have arranged");
    }

    @GetMapping("/{eventid}")
    public ResponseEntity<List<SeatResponse>> getAllByEvent(@PathVariable Long eventid)
    {
        List<SeatResponse> r = service.getAllSeatsByEventId(eventid);
        return ResponseEntity.ok().body(r);
    }

    @GetMapping("/event/{eventId}/available")
    public ResponseEntity<List<SeatResponse>> getAllByEventAndAvailable(@PathVariable Long eventId)
    {
        List<SeatResponse> r = service.getAllByEventAndAvailable(eventId);
        return ResponseEntity.ok().body(r);
    }

//    @GetMapping("/{id}/seat")
//    ResponseEntity<SeatResponse> getSeatById(@PathVariable Long id);

    @GetMapping("/{id}/seat")
    public ResponseEntity<SeatResponse> getSeatById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(service.getSeatById(id));
    }

    @PutMapping("/not")
    public ResponseEntity<String> markUnavailable(@RequestBody RequestSeatNumber seatNumber)
    {
        service.markUnavailable(seatNumber.getSeatNumber());
        return ResponseEntity.ok().body("marked as lokeded");

    }

    @PutMapping("/status/{id}")
    public void markingTheStatus(@PathVariable Long id, @RequestParam Boolean status)
    {
        service.markingTheStatus(id,status);
    }

    @PutMapping("/status/lock/{id}")
    public void markingAsLocked(@PathVariable Long id)
    {
        service.markingAsLocked(id);
    }



}
