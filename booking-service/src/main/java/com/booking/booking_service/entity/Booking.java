package com.booking.booking_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long eventId;
    private Long seatId;
    private BookingStatus status;

    public Booking(Long userId, Long eventId, Long seatId) {
        this.userId = userId;
        this.eventId = eventId;
        this.seatId = seatId;
    }
}
