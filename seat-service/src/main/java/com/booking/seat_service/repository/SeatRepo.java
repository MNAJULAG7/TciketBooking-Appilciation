package com.booking.seat_service.repository;

import com.booking.seat_service.entity.Seat;
import com.booking.seat_service.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Long> {
    List<Seat> findAllByEventId(Long eventid);

    List<Seat> findAllByEventIdAndStatus(Long eventId, Status status);
}
