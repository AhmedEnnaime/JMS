package com.learning.jms.listeners;

import com.learning.jms.config.JmsConfig;
import com.learning.jms.models.HelloWorldMessage;
import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders messageHeaders, Message message) {
        System.out.println("I got a hello message: " + helloWorldMessage);
    }
}
