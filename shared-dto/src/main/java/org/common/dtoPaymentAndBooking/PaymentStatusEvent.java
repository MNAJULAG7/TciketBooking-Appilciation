package org.common.dtoPaymentAndBooking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatusEvent {
    private Long bookingId;
    private String status; // SUCCESS / FAILED
}
