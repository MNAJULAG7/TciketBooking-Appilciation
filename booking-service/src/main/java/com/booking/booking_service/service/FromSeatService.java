package com.booking.booking_service.service;

import com.booking.booking_service.payload.SeatResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SEAT-SERVICE", path = "/api/seats")
public interface FromSeatService {
    @GetMapping("/{id}/seat")
    ResponseEntity<SeatResponse> getSeatById(@PathVariable Long id);

    @PutMapping("/status/{id}")
    void markingTheStatus(@PathVariable Long id, @RequestParam Boolean status);

    @PutMapping("/status/lock/{id}")
    void markingAsLocked(@PathVariable Long id);
}
