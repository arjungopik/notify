import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class WhatsAppService {

    private final String ACCOUNT_SID = "YOUR_ACCOUNT_SID";
    private final String AUTH_TOKEN = "YOUR_AUTH_TOKEN";

    public WhatsAppService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
//
//    public void sendMenu(String to) {
//
//        Message.creator(
//                new com.twilio.type.PhoneNumber(to),
//                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"), // sandbox number
//                ""
//        ).setPersistentAction(
//                java.util.List.of(
//                        URI.create("button:Take Appointment"),
//                        URI.create("button:Cancel Appointment"),
//                        URI.create("button:Reschedule")
//                )
//        ).create();
//    }
}