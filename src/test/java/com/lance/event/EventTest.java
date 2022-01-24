package com.lance.event;

import com.lance.event.config.EventConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Lance
 * @since 2021/7/14
 */
@SpringBootTest(classes = EventTest.Config.class)
public class EventTest {

    @Autowired
    private EventBus eventBus;

    @Test
    public void test() {
        eventBus.publishEvent(new TestEvent(this));
    }

    @SpringBootApplication
    @Import(EventConfiguration.class)
    public static class Config {
    }
}