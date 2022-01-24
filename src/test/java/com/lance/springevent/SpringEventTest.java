package com.lance.springevent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Lance
 * @since 2021/7/14
 */
@SpringBootTest(classes = SpringEventTest.Config.class)
public class SpringEventTest {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Test
    public void test() {
        eventPublisher.publishEvent(new TestEvent(this));
    }

    @SpringBootApplication
    @EnableAsync
    public static class Config {
    }
}