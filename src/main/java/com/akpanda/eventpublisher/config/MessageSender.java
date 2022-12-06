package com.akpanda.eventpublisher.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue quoromQueue;

    @Autowired
    private Queue streamQueue;

    public void sendToQuoromQueue(String message) {
        try{
            rabbitTemplate.convertAndSend(this.quoromQueue.getName(), message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendToStreamQueue(String message) {
        try{
            rabbitTemplate.convertAndSend(this.streamQueue.getName(), message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}