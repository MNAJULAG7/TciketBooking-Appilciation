package com.booking.seat_service.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatResponse {

    private Long id;
    private Long eventId;
    private Long seatNumber;
    private String status;
}
