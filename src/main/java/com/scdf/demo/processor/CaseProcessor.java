package com.scdf.demo.processor;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import java.awt.desktop.OpenURIEvent;
import java.util.function.Function;

@Component
public interface CaseProcessor  extends Processor {

    String INPUT = "input";
    @Input(INPUT)
    SubscribableChannel input();

    String OUTPUT = "output";
    @Output(OUTPUT)
    MessageChannel output();

}
