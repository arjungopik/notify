package com.notification_service.notify.repository;

import com.notification_service.notify.domain.entity.Booking;
import com.notification_service.notify.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here if needed
}

