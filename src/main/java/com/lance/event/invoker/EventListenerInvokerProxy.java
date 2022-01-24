package com.lance.event.invoker;

import com.lance.event.executor.EventListenerExecutor;
import com.lance.event.Event;

/**
 * @author Lance
 * @since 2021/7/14
 */
public class EventListenerInvokerProxy implements EventListenerInvoker {

    private final EventListenerExecutor executor;

    private final EventListenerInvoker invoker;

    public EventListenerInvokerProxy(EventListenerExecutor executor, EventListenerInvoker invoker) {
        this.executor = executor;
        this.invoker = invoker;
    }

    @Override
    public boolean supportEvents(Class<?> eventType) {
        return invoker.supportEvents(eventType);
    }

    @Override
    public void invokeListener(Event event) {
        executor.invokeListener(invoker, event);
    }

    public EventListenerExecutor getExecutor() {
        return executor;
    }

    public EventListenerInvoker getInvoker() {
        return invoker;
    }
}
