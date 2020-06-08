package com.sms.demo;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * SmsController class to represent the class of creating the http request '/sms'
 * Output will be response that will be passed after the http request executed.
 *
 * Response type 'application/xml'
*/
@RestController
public class SmsController {

    @RequestMapping(value = "/sms")
    @ResponseBody
    public String getTwiMLResponse() {
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
    public String getLanding() {
        return "Welcome to lading page for SMS! Use /sms for webook to trigger.";
    }
}
