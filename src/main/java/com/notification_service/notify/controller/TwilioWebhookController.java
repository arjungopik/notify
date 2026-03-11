package com.notification_service.notify.controller;
import com.notification_service.notify.service.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/twilio")
public class TwilioWebhookController {
//
//    private final WhatsAppService whatsAppService;
//
//    public TwilioWebhookController(WhatsAppService whatsAppService) {
//        this.whatsAppService = whatsAppService;
//    }
//
//    @PostMapping("/incoming")
//    public void receiveMessage(
//            @RequestParam("Body") String body,
//            @RequestParam("From") String from
//    ) {
//
//        if (body.equalsIgnoreCase("hi")) {
//            whatsAppService.sendMenu(from);
//        }
//    }
}