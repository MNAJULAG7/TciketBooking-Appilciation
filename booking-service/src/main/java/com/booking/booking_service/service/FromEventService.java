package com.booking.booking_service.service;

import com.booking.booking_service.payload.EventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENT-SERVICE", path = "/api/events")
public interface FromEventService {

    @GetMapping("/{id}")
    ResponseEntity<EventResponse> getEventById(@PathVariable Long id);

}
