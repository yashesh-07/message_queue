package com.yashesh.mq_demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue myQueue() {
        // This tells Spring: "When you start, check if 'my_learning_queue' exists.
        // If it doesn't, tell RabbitMQ to create it."
        // The 'true' means the queue is DURABLE (it survives if RabbitMQ restarts).
        return new Queue("my_learning_queue", true);
    }
}