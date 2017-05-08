package com.yuan.boot.reactor.model;

/**
 * Created by yuanxin on 17/5/7.
 */
public class Event
{
    public EventType type;
    public Source source;

    public EventType getType()
    {
        return type;
    }

    public void setType(EventType type)
    {
        this.type = type;
    }

    public Source getSource()
    {
        return source;
    }

    public void setSource(Source source)
    {
        this.source = source;
    }
}
