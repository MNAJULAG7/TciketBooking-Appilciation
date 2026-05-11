package com.booking.booking_service.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String eventname;
    private String location;
    private LocalDate date;
    private Long total_seats;
    private Double amount;
}
