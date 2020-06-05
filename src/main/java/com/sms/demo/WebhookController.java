package com.sms.demo;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebhookController {

    @RequestMapping(value = "/sms")
    @ResponseBody
    public String getTwiML() {
        Body body = new Body
                .Builder("Thank you for the message!")
                .build();
        Message sms = new Message
                .Builder()
                .body(body)
                .build();
        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();
        return twiml.toXml();
    }

    @RequestMapping("/")
    public String getHello(){
        return "Hello";
    }
}
