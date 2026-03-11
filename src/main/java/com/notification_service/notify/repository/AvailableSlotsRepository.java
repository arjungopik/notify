package com.notification_service.notify.repository;
import com.notification_service.notify.domain.entity.AvailableSlots;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableSlotsRepository extends JpaRepository<AvailableSlots,Long> {
}
