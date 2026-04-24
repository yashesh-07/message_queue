package com.yashesh.mq_demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    // This is our 'mail carrier' provided by Spring Boot
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String msg) {
        // We tell the carrier: "Deliver this msg to 'my_learning_queue'"
        rabbitTemplate.convertAndSend("my_learning_queue", msg);
        
        return "Message sent to the queue: " + msg;
    }
}