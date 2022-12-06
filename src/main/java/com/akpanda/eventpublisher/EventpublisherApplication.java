package com.akpanda.eventpublisher;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventpublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventpublisherApplication.class, args);
	}

}
