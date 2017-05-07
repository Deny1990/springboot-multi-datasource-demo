package com.yuan.boot.reactor;

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
