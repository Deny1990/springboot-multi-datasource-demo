package com.yuan.boot.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Demultiplexer
{
    private BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
    private Object lock = new Object();

    List<Event> select() {
        return select(0);
    }

    List<Event> select(long timeout) {
        if (timeout > 0) {
            if (eventQueue.isEmpty()) {
                synchronized (lock) {
                    if (eventQueue.isEmpty()) {
                        try {
                            lock.wait(timeout);
                        } catch (InterruptedException e) {
                            // ignore it
                        }
                    }
                }

            }
        }
        List<Event> events = new ArrayList<Event>();
        eventQueue.drainTo(events);
        return events;
    }
    public void addEvent(Event e) {
        boolean success = eventQueue.offer(e);
        if (success) {
            synchronized (lock) {
                lock.notify();
            }

        }
    }


}
