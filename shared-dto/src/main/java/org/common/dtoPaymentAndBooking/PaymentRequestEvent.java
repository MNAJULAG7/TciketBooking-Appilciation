package org.common.dtoPaymentAndBooking;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestEvent {
    private Long bookingId;
    private Double amount;
    private Long userId;
    private String paymentMethod;

}