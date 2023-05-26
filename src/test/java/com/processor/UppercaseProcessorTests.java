package com.processor;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.support.MessageBuilder;



//@SpringBootTest
//public class UppercaseProcessorTests {
//
//  @Autowired
//  private Processor processor;
//
//  @Autowired
//  private MessageCollector collector;
//
//  @Test
//  public void testUppercaseProcessor() {
//    Message<String> message = MessageBuilder.withPayload("test").build();
//    processor.input().send(message);
//
//    Message<?> outputMessage = collector.forChannel(processor.output()).poll();
//    assertThat(outputMessage.getPayload()).isEqualTo("TEST");
//  }
//}
