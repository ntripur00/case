package com.scdf.demo.processor;

import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.config.ListenerContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CaseProcessor.class)
public class CaseProcessing {

  private   CaseProcessor caseProcessor;

  @Autowired
  public CaseProcessing(CaseProcessor caseProcessor) {
    this.caseProcessor = caseProcessor;
  }

  @EventListener(ApplicationStartedEvent.class)
  void logStartEvent(){
    System.out.println("The Case Application has started...");
  }

  private static final <T> Message<T> message(T val) {
    return MessageBuilder.withPayload(val).build();
  }


  @StreamListener(CaseProcessor.INPUT)
  @SendTo(CaseProcessor.OUTPUT)
  public void transform(Message<String> message) {
    String pl = message.getPayload();
    System.out.println("the payload is {}"+pl);

    String payload = pl.toUpperCase();
    System.out.println("the uppercased payload is {}"+payload);

//		caseProcessor.output().send(message(payload));

    caseProcessor.output().send(message(payload));
  }


  // for exceptions
  @Bean
  public ListenerContainerCustomizer<AbstractMessageListenerContainer> listenerContainerCustomizer() {
    return (container, dest, group) -> container.setErrorHandler(t -> System.out.println("Error in listener " +t));
  }

}
