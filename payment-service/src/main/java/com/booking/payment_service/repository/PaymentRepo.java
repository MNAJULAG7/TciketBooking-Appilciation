package com.booking.payment_service.repository;

import com.booking.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    boolean existsByBookingId(Long bookingId);
}
