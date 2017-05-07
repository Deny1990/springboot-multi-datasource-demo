package com.yuan.boot.reactor;

/**
 * Created by yuanxin on 17/5/7.
 */
public class AcceptEventHandler extends EventHandler
{
    private Demultiplexer selector;

    public AcceptEventHandler(Demultiplexer selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (event.type == EventType.ACCEPT) {

            Event readEvent = new Event();
            readEvent.source = event.source;
            readEvent.type = EventType.READ;

            selector.addEvent(readEvent);
        }
    }


}
