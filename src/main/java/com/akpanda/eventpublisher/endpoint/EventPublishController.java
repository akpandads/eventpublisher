package com.akpanda.eventpublisher.endpoint;

import com.akpanda.eventpublisher.config.MessageSender;
import com.akpanda.eventpublisher.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/event")
public class EventPublishController {

    @Autowired
    MessageSender messageSender;

    private final static Logger LOGGER = Logger.getLogger(EventPublishController.class.getName());
    @PostMapping("v1/publish/quorom")
    public void publishToQuoromQueue(@RequestBody EventModel eventModel){
        LOGGER.info("Inside publish start");
        messageSender.sendToQuoromQueue(eventModel.getMessage());
        LOGGER.info("Inside publish end");
    }

    @PostMapping("v1/publish/stream")
    public void publishToStreamQueue(@RequestBody EventModel eventModel){
        LOGGER.info("Inside publish start");
        messageSender.sendToStreamQueue(eventModel.getMessage());
        LOGGER.info("Inside publish end");
    }
}
