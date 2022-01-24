package com.lance.event.config;

import com.lance.event.EventBus;
import com.lance.event.invoker.EventListenerInvokerFactory;
import com.lance.event.EventListenerProcessor;
import com.lance.event.executor.AsyncEventListenerExecutor;
import com.lance.event.executor.SyncEventListenerExecutor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Lance
 * @since 2021/7/14
 */
public class EventConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SyncEventListenerExecutor syncEventListenerExecutor() {
        return new SyncEventListenerExecutor();
    }

    @Bean
    @ConditionalOnMissingBean
    public AsyncEventListenerExecutor asyncEventListenerExecutor() {
        return new AsyncEventListenerExecutor();
    }

    @Bean
    public EventListenerInvokerFactory eventListenerInvokerFactory() {
        return new EventListenerInvokerFactory();
    }

    @Bean
    public EventBus eventBus(EventListenerInvokerFactory factory) {
        return new EventBus(factory);
    }

    @Bean
    public EventListenerProcessor eventListenerProcessor(EventBus eventBus) {
        return new EventListenerProcessor(eventBus);
    }
}
