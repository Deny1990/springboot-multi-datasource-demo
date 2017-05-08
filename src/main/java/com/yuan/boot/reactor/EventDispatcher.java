package com.yuan.boot.reactor;

import com.yuan.boot.reactor.handler.EventHandler;
import com.yuan.boot.reactor.model.Event;
import com.yuan.boot.reactor.model.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuanxin on 17/5/7.
 */
public class EventDispatcher
{
    Logger logger = LoggerFactory.getLogger(EventDispatcher.class);

    Map<EventType, EventHandler>
        eventHandlerMap = new ConcurrentHashMap<EventType, EventHandler>();

   Demultiplexer selector;

    EventDispatcher(Demultiplexer selector) {
        this.selector = selector;
    }

    public void registEventHandler(EventType eventType, EventHandler eventHandler) {
        eventHandlerMap.put(eventType, eventHandler);

    }

    public void removeEventHandler(EventType eventType) {
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents() {
        dispatch();
    }
    private void dispatch() {
        while (true) {
            List<Event> events = selector.select();

            for (Event event : events) {
                logger.info("event 为{}",event.getType().name());
                EventHandler eventHandler = eventHandlerMap.get(event.type);
                eventHandler.handle(event);
            }
        }
    }

}
