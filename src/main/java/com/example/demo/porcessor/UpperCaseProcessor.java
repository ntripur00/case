package com.example.demo.porcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
@Slf4j
public class UpperCaseProcessor {

  @StreamListener(Processor.INPUT)
  @SendTo(Processor.OUTPUT)
  public String process(String payload) {
    log.debug("\nthe payload is --> \n{}\n",payload);
    String uppercasePayload = payload.toUpperCase();
    log.debug("\nthe uppercase payload is --> \n{}\n",uppercasePayload);
    return uppercasePayload;
  }

}
