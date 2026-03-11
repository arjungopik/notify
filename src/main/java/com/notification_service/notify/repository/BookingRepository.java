package com.notification_service.notify.repository;

import com.notification_service.notify.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    
}
