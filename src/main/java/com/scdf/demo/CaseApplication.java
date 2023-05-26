package com.scdf.demo;



import com.scdf.demo.processor.CaseProcessor;

import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

import org.springframework.context.event.EventListener;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
//@Slf4j
//@EnableBinding(Processor.class)
public class CaseApplication {


	public static void main(String[] args) {
		SpringApplication.run(CaseApplication.class, args);
	}







	 //rabbitmq test
//	 @Bean
//	 public CommandLineRunner run(RabbitTemplate rabbitTemplate) {
//		 return args -> {
//			 String message = "Test message";
//			 System.out.println("Sending message...");
//			 rabbitTemplate.convertAndSend("testQueue", message);
//			 System.out.println("Message sent!");
//		 };
//	 }

}
