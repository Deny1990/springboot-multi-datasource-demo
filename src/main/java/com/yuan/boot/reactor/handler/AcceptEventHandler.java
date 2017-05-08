package com.yuan.boot.reactor.handler;

import com.yuan.boot.reactor.Demultiplexer;
import com.yuan.boot.reactor.model.Event;
import com.yuan.boot.reactor.model.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanxin on 17/5/7.
 */
public class AcceptEventHandler extends EventHandler
{
    Logger logger = LoggerFactory.getLogger(AcceptEventHandler.class);

    private Demultiplexer selector;

    public AcceptEventHandler(Demultiplexer selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        if (event.type == EventType.ACCEPT) {
            logger.info("the source is {}",event.getSource());
            logger.info("开始接受请求");
            Event readEvent = new Event();
            readEvent.source = event.source;
            readEvent.type = EventType.READ;
            logger.info("生成读事件完毕");
            selector.addEvent(readEvent);
            logger.info("加入selector");
        }
    }


}
