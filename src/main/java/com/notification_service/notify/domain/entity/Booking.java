package com.notification_service.notify.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut;

import java.time.LocalTime;

@Entity
@Table(name="bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="slot_id")
    private AvailableSlots availableSlots;

}
