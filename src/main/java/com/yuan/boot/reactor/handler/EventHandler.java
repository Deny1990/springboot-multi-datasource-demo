package com.yuan.boot.reactor.handler;

import com.yuan.boot.reactor.model.Event;
import com.yuan.boot.reactor.model.Source;

/**
 * Created by yuanxin on 17/5/7.
 */
public abstract class EventHandler
{
    Source source;

    public abstract void handle(Event event);

    public Source getSource() {
        return source;
    }
}
