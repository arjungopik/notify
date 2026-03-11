package com.notification_service.notify.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WhatsAppWebhookController {

    @Value("${whatsapp.verify.token}")
    private String verifyToken;

    @Value("${whatsapp.access.token}")
    private String accessToken;

    @Value("${whatsapp.phone.number.id}")
    private String phoneNumberId;

    private final RestTemplate restTemplate = new RestTemplate();

    // 1️⃣ Verification endpoint (GET)
    @GetMapping
    public ResponseEntity<String> verifyWebhook(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String token,
            @RequestParam("hub.challenge") String challenge) {

        if ("subscribe".equals(mode) && verifyToken.equals(token)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    // 2️⃣ Receive message (POST)
    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody Map<String, Object> payload) {

        try {
            Map entry = ((List<Map>) payload.get("entry")).get(0);
            Map changes = ((List<Map>) entry.get("changes")).get(0);
            Map value = (Map) changes.get("value");
            List<Map> messages = (List<Map>) value.get("messages");

            if (messages != null) {
                Map message = messages.get(0);
                String from = (String) message.get("from");
                Map textObj = (Map) message.get("text");
                String body = (String) textObj.get("body");

                if ("hi".equalsIgnoreCase(body)) {
                    sendReply(from, "Hi 👋 How can I help you?");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("EVENT_RECEIVED");
    }

    private void sendReply(String to, String message) {

        String url = "https://graph.facebook.com/v19.0/" + phoneNumberId + "/messages";

        Map<String, Object> request = new HashMap<>();
        request.put("messaging_product", "whatsapp");
        request.put("to", to);
        request.put("type", "text");

        Map<String, String> text = new HashMap<>();
        text.put("body", message);

        request.put("text", text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);

        restTemplate.postForEntity(url, entity, String.class);
    }
}