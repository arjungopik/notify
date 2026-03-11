package com.notification_service.notify.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="slots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableSlots {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long slotId;

    private LocalDate date;

    private String location;

    private LocalTime startTime;
    private LocalTime endTime;

    private int numberOfSlots;
}
