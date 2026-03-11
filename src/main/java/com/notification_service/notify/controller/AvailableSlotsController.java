package com.notification_service.notify.controller;


import com.notification_service.notify.domain.entity.AvailableSlots;
import com.notification_service.notify.service.AvailableSlotsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slots")
@RequiredArgsConstructor
public class AvailableSlotsController {
    public final AvailableSlotsService availableSlotsService;

    @PostMapping
    public AvailableSlots createAvailableSlots(@RequestBody AvailableSlots availableSlots) {
        return availableSlotsService.createAvailableSlots(availableSlots);
    }
}
