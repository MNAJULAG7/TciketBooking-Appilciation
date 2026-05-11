package com.booking.seat_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "EVENT-SERVICE" , path = "/api/events")
public interface FromEventService {

    @GetMapping("/seat/{eventId}")
    Long getById(@PathVariable Long eventId);


}
