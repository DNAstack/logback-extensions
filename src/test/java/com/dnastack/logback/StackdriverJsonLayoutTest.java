package com.dnastack.logback;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StackdriverJsonLayoutTest {

    private ListAppender<ILoggingEvent> appender;
    private final Logger log = (Logger) LoggerFactory.getLogger(StackdriverJsonLayout.class);

    @BeforeEach
    public void setup() {
        appender = new ListAppender<>();
        appender.start();
        log.addAppender(appender);
    }

    @AfterEach
    public void teardown() {
        log.detachAppender(appender);
    }

    @Test
    public void levelFieldBecomesSeverity(){
        log.info("Hello, world!");
        Map processedEvent = new StackdriverJsonLayout().toJsonMap(appender.list.get(appender.list.size() -1));
        assert ((String)processedEvent.get("severity")).equalsIgnoreCase("info");

        log.warn("Hasta la vista");
        processedEvent = new StackdriverJsonLayout().toJsonMap(appender.list.get(appender.list.size() -1));
        assert ((String)processedEvent.get("severity")).equalsIgnoreCase("warn");
    }
}
