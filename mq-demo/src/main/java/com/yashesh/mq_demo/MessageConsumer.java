package com.yashesh.mq_demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    // This tells Spring Boot: "Keep this connection open forever.
    // If a message arrives in 'my_learning_queue', run this method."
    @RabbitListener(queues = "my_learning_queue")
    public void receiveMessage(String message) {
        System.out.println("---------------------------------------");
        System.out.println("CONSUMER RECEIVED: " + message);
        System.out.println("---------------------------------------");
    }
}