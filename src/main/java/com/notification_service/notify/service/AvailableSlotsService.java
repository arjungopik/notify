    package com.notification_service.notify.service;
    import org.springframework.stereotype.Service;
    import com.notification_service.notify.domain.entity.AvailableSlots;
    import com.notification_service.notify.repository.AvailableSlotsRepository;
    import lombok.RequiredArgsConstructor;

    @Service
    @RequiredArgsConstructor
    public class AvailableSlotsService {
            private final AvailableSlotsRepository availableSlotsRepository;

            public AvailableSlots createAvailableSlots(AvailableSlots availableSlots) {
                return availableSlotsRepository.save(availableSlots);
            }

    }
