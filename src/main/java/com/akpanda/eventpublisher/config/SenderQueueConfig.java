package com.akpanda.eventpublisher.config;


import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableRabbit
public class SenderQueueConfig {
    @Value("${rabbit.quorom.queue.name}")
    private String quoromQueueName;

    @Value("${rabbit.stream.queue.name}")
    private String streamQueueName;

    @Bean
    public Queue quoromQueue() {
        return  new Queue(quoromQueueName, true, false, false, Map.of(
                "x-queue-type", "quorum"));
    }

    @Bean
    public Queue streamQueue() {
        return new Queue(streamQueueName, true, false, false, Map.of(
                "x-queue-type", "stream"));
    }

}

