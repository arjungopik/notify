package com.notification_service.notify.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @PostMapping
    public String receiveMessage(
            @RequestParam("From") String from,
            @RequestParam("Body") String body) {

        System.out.println("Message from: " + from);
        System.out.println("Body: " + body);

        return"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<Response>" +
                "<Message>hi</Message>" +
                "</Response>";
    }
}