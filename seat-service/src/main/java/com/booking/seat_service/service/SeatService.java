package com.booking.seat_service.service;

import com.booking.seat_service.payload.SeatResponse;

import java.util.List;

public interface SeatService {
    void allocateSeats(long eventid);

    List<SeatResponse> getAllSeatsByEventId(Long eventid);

    List<SeatResponse> getAllByEventAndAvailable(Long eventId);

    void markUnavailable(List<Long> seatId);

    SeatResponse getSeatById(Long id);

}
