package com.booking.booking_service.payload;

import com.booking.booking_service.entity.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingResponse {

    private Long id;
    private Long userId;
    private Long eventId;
    private Long seatId;
    private String status;

}
