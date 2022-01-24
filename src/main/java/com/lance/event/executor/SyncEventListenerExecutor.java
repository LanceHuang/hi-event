package com.lance.event.executor;

import com.lance.event.invoker.EventListenerInvoker;
import com.lance.event.Event;

/**
 * 同步事件执行器
 *
 * @author Lance
 * @since 2021/7/14
 */
public class SyncEventListenerExecutor extends AbstractEventListenerExecutor {

    @Override
    public void invokeListener(EventListenerInvoker invoker, Event event) {
        try {
            invoker.invokeListener(event);
        } catch (Exception e) {
            getExceptionHandler().handleError(event, e);
        }
    }
}
