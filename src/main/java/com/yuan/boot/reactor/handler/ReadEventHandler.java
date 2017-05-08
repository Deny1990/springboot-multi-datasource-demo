package com.yuan.boot.reactor.handler;

import com.yuan.boot.reactor.Demultiplexer;
import com.yuan.boot.reactor.model.EventType;
import com.yuan.boot.reactor.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yuanxin on 17/5/7.
 */
public class ReadEventHandler extends EventHandler
{
    // private Pipeline pipeline;
    Logger logger = LoggerFactory.getLogger(ReadEventHandler.class);

    private Demultiplexer selector;

    public ReadEventHandler(Demultiplexer selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        logger.info("the source is {}",event.getSource());
        // create channel with a pipeline
        // register the channel to this event dispatcher or a child event dispatcher


        // handle event use the pipeline :
        // step 1:  read to a frame buffer
        // step 2:  use frame decoder to decode buffer as a message (maybe a business object)
        // step 3:  handle the message or submit the message to business thread pool
        // step 4:  register a message event
        logger.info("处理读事件");
        Event readEvent = new Event();
        readEvent.source = event.source;
        readEvent.type = EventType.WRITE;
        logger.info("生成写事件完毕");
        selector.addEvent(readEvent);
        logger.info("加入selector");

 }

}
